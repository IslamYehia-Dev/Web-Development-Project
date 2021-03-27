/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.naming.spi.DirStateFactory;
import javax.servlet.http.HttpSession;

/**
 *
 * @author eslam
 */
public class AccessHandler {

    public static double getOrderTotal(int billno) {
        double tot = 0;

        try {
            Statement newstmt = DataBaseConnector.connection.createStatement();
            ResultSet rsset = newstmt.executeQuery("select c.cat_name,i.name,d.quantity,i.price from  order_details d , item i , category c  where c.category_id=i.cat_id and   d.billno= " + billno + "  and d.item_id = i.item_id");
            while (rsset.next()) {
                tot += rsset.getInt(3) * rsset.getDouble(4);

            }
        } catch (SQLException ex) {
            Logger.getLogger(AccessHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tot;
    }

    public static List<OrderedItem> getOrderDetails(int billno) {
        List<OrderedItem> orderDetails = new ArrayList<>();

        try {
            Statement newstmt = DataBaseConnector.connection.createStatement();
            ResultSet rsset = newstmt.executeQuery("select c.cat_name,i.name,d.quantity,i.price from  order_details d , item i , category c  where c.category_id=i.cat_id and   d.billno= " + billno + "  and d.item_id = i.item_id");
            while (rsset.next()) {
                orderDetails.add(new OrderedItem(rsset.getInt(3), rsset.getDouble(4), rsset.getString(2), rsset.getString(1)));

            }
        } catch (SQLException ex) {
            Logger.getLogger(AccessHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return orderDetails;
    }

    public static List<Order> getOrders() {
        List<Order> allOrders = new ArrayList<>();
        try {
            Statement stmt = DataBaseConnector.connection.createStatement();
            ResultSet rs = stmt.executeQuery("select  o.billno , u.uname , o.datee from orders  o , users u  where u.id=o.user_id ");
            while (rs.next()) {
                allOrders.add(new Order(rs.getInt(1), rs.getString(3), rs.getString(2), getOrderTotal(rs.getInt(1)), getOrderDetails(rs.getInt(1))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccessHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return allOrders;
    }

    public static void updateUserBalance(int userID, double total) {
        try {
            PreparedStatement prSTMT = DataBaseConnector.connection.prepareStatement("update users set creditlimit=creditlimit - ? where id=?");
            prSTMT.setDouble(1, total);
            prSTMT.setInt(2, userID);
            prSTMT.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccessHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void updateItemsQuantity(List<Product> prods) {
        for (int i = 0; i < prods.size(); i++) {
            Product x = prods.get(i);
            try {
                PreparedStatement prSTMT = DataBaseConnector.connection.prepareStatement("update item set quantity = quantity - ? where item_id= ? ");
                prSTMT.setInt(1, x.orderedQuantity);
                prSTMT.setInt(2, x.id);
                prSTMT.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(AccessHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    // 1 available , 0 not available
    public static int checkItemAvilability(Product q) {
        try {
            PreparedStatement prSTMT = DataBaseConnector.connection.prepareStatement("select item_id from item where item_id = ? and quantity >= ?");
            prSTMT.setInt(1, q.id);
            prSTMT.setInt(2, q.orderedQuantity);
            ResultSet rset = prSTMT.executeQuery();
            if (rset.next()) {
                return 1;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AccessHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    // 1 avlbl balance , 0 not enough
    public static int checkAmount(int userID, double total) {
        try {
            PreparedStatement prSTMT = DataBaseConnector.connection.prepareStatement("select id from users where id = ? and creditlimit >= ?");
            prSTMT.setInt(1, userID);
            prSTMT.setDouble(2, total);
            ResultSet rset = prSTMT.executeQuery();
            if (rset.next()) {
                return 1;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AccessHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static void makeOrder(int userId, String orderDate, List<Product> prods) {
        double total = 0;
        int avlbls = 0;
        for (int i = 0; i < prods.size(); i++) {
            avlbls += checkItemAvilability(prods.get(i));
            total += prods.get(i).price * prods.get(i).orderedQuantity;
        }
        if (checkAmount(userId, total) == 1 && avlbls == prods.size()) {
            int billno = 0;
            try {
                Statement stm = DataBaseConnector.connection.createStatement();
                stm.executeUpdate("insert into orders (user_id,datee) values('" + userId + "','" + orderDate + "')");
                ResultSet rsSet = stm.executeQuery("select max(billno) from orders where user_id = '" + userId + "' and datee='" + orderDate + "'");
                if (rsSet.next()) {
                    billno = rsSet.getInt(1);
                    for (int i = 0; i < prods.size(); i++) {
                        makeOrderDetail(billno, prods.get(i));
                    }
                    updateUserBalance(userId, total);
                    updateItemsQuantity(prods);
                }

            } catch (SQLException ex) {
                Logger.getLogger(AccessHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void makeOrderDetail(int billno, Product prod) {
        try {
            Statement stm = DataBaseConnector.connection.createStatement();
            stm.executeUpdate("insert into order_details  values('" + billno + "','" + prod.id + "','" + prod.orderedQuantity + "')");
        } catch (SQLException ex) {
            Logger.getLogger(AccessHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void editProduct(List<Product> prods) {
        prods.forEach((x) -> {
            editProduct(x);
        });
    }

    public static void editProduct(Product x) {
        try {
            PreparedStatement stm;
            stm = DataBaseConnector.connection.prepareStatement("update item set name = ? , quantity = ? , price = ?   where item_id = ? ");
            stm.setString(1, x.name);
            stm.setInt(2, x.quantity);
            stm.setDouble(3, x.price);
            stm.setInt(4, x.id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccessHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void addProduct(Product x) {
        try {
            PreparedStatement stm;
            stm = DataBaseConnector.connection.prepareStatement("insert into item ( name , quantity  , price , img , cat_id ) values(?,?,?,?,?)");
            stm.setString(1, x.name);
            stm.setInt(2, x.quantity);
            stm.setDouble(3, x.price);
            stm.setString(4, x.img);
            stm.setInt(5, x.cat_no);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccessHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<Product> getProducts(List<Integer> ids) {
        List<Product> prods = new ArrayList<>();
        if (ids != null) {
            try {
                ResultSet rs;
                PreparedStatement stm;
                stm = DataBaseConnector.connection.prepareStatement("select * from item , category where item_id = ? and category_id = cat_id ");

                for (int i = 0; i < ids.size(); i++) {
                    int curId = ids.get(i);
                    stm.setInt(1, curId);
                    rs = stm.executeQuery();
                    if (rs.next()) {
                        boolean found = false;
                        for (int j = 0; j < prods.size(); j++) {
                            if (prods.get(j).id == rs.getInt("item_id")) {
                                found = true;
                                prods.get(j).orderedQuantity += 1;
                            }
                        }
                        if (!found) {
                            prods.add(new Product(rs.getInt("item_id"), rs.getString("name"), rs.getInt("quantity"), rs.getDouble("price"), rs.getString("category_id"), rs.getString("img")));
                        }
                    }
                }

            } catch (SQLException ex) {
                Logger.getLogger(AccessHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return prods;
    }

    public static List<Product> getProducts() {
        List<Product> prods = new ArrayList<>();
        try {

            ResultSet rs;
            PreparedStatement stm;
            stm = DataBaseConnector.connection.prepareStatement("select * from item , category where category_id = cat_id");
            rs = stm.executeQuery();
            while (rs.next()) {
                prods.add(new Product(rs.getInt("item_id"), rs.getString("name"), rs.getInt("quantity"), rs.getDouble("price"), rs.getString("category_id"), rs.getString("img")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(AccessHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prods;

    }

    public static int verifyLogin(String username, String password, User user) {
        boolean invalidLogin = false;
        boolean adminLogin = false;
        String fetchedName = "";
        int id = 0;
        String pword = "";
        String email = "";
        boolean type;
        String brithday = "";
        String job = "";
        double credit = 0.00;
        String address = "";
        ResultSet result;

        try {

            PreparedStatement pst2 = DataBaseConnector.connection.prepareStatement("select * from users where uname = ? and password = ?");
            pst2.setString(1, username);
            pst2.setString(2, password);
            result = pst2.executeQuery();
            while (result.next()) {

                if (result.getBoolean(5) == true) {
                    adminLogin = true;
                }
                fetchedName = result.getString(3);
                user.id = result.getInt(1);
                user.password = result.getString(2);
                user.uname = result.getString("uname");
                user.email = result.getString("email");
                user.type = result.getBoolean("type");
                user.birthday = result.getString("birthday");
                user.job = result.getString("job");
                user.credit_Limit = result.getDouble("creditlimit");
                user.address = result.getString("address");
            }
            if (fetchedName.equals("")) {
                invalidLogin = true;

            }

            if (invalidLogin) {
                return 0;
            } else {
                if (adminLogin) {
                    return -1;
                } else {

                    return 1;

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int registerUser(User user) {
        int currentId = 0;
        int updateStatus = 0;
        boolean invalidUser = false;

        try {

            PreparedStatement pst = DataBaseConnector.connection.prepareStatement("select MAX(id) from users");

            ResultSet result = pst.executeQuery();
            while (result.next()) {

                currentId = result.getInt(1);
            }
            currentId++;

            PreparedStatement pst2 = DataBaseConnector.connection.prepareStatement("select uname from users");
            result = pst2.executeQuery();
            while (result.next()) {
                if (result.getString(1).equals(user.uname)) {
                    invalidUser = true;
                }

            }

            if (!invalidUser) {
                pst = DataBaseConnector.connection.prepareStatement("insert into users values(?,?,?,?,?,?,?,?,?)");
                pst.setInt(1, currentId);
                pst.setString(2, user.password);
                pst.setString(3, user.uname);
                pst.setString(4, user.email);
                pst.setObject(5, false);
                pst.setString(6, user.birthday);
                pst.setString(7, user.job);
                pst.setObject(8, 1000.00);
                pst.setString(9, user.address);
                updateStatus = pst.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (updateStatus != 0) {
            user.id = currentId;
            for (int i = 0; i < user.myInts.size(); i++) {

                try {
                    PreparedStatement ntstmt = DataBaseConnector.connection.prepareStatement("insert into interests values (?,?)");
                    ntstmt.setInt(1, user.id);
                    ntstmt.setString(2, user.myInts.get(i));
                    ntstmt.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(AccessHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return 1;

        } else {
            return 0;
        }
    }

//    public static HashMap<Integer, Product> hashProducts(List<Product> prodCart) {
//        HashMap<Integer, Product> myHash = new HashMap<Integer, Product>();
//        // iterate - init - increment 
//        prodCart.forEach((Product x) -> {
//            if (myHash.get(x.id) == null) {
//                x.orderedQuantity = 1;
//                myHash.put(x.id, x);
//            } else {
//                myHash.get(x.id).orderedQuantity += 1;
//            }
//        });
//
//        return myHash;
//    }

    public static Vector<User> listUsers() {
        ResultSet result;
        Vector<User> users = new Vector<>();
        try {
            PreparedStatement pst = DataBaseConnector.connection.prepareStatement("select id,uname,email,birthday,job,creditlimit,address from users where type=false");
            result = pst.executeQuery();
            while (result.next()) {
                User user = new User();
                user.id = result.getInt(1);
                user.uname = result.getString(2);
                user.email = result.getString(3);
                user.birthday = result.getString(4);
                user.job = result.getString(5);
                user.credit_Limit = result.getDouble(6);
                user.address = result.getString(7);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public static List<Category> getCats() {
        List<Category> categories = new ArrayList<>();
        try {

            ResultSet rs;
            Statement stm;
            stm = DataBaseConnector.connection.createStatement();
            rs = stm.executeQuery("select * from category");
            while (rs.next()) {
                categories.add(new Category(rs.getInt("category_id"), rs.getString("cat_name")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(AccessHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categories;
    }

    public static int deleteUser(String userName) {

        ResultSet result;
        int deleteStatus = 0;
        try {
            PreparedStatement pst = DataBaseConnector.connection.prepareStatement("delete from users where uname = ?");
            pst.setString(1, userName);
            deleteStatus = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deleteStatus;
    }

    public static int editProfile(HashMap<String, String> userData) {
        ResultSet result;
        int updateStatus = 0;
        String username = "";
        Set keys = userData.keySet();
        String[] fields = new String[keys.size()];
        keys.toArray(fields);
        try {
            for (int i = 0; i < fields.length; i++) {
                PreparedStatement pst = DataBaseConnector.connection.prepareStatement("update users set " + fields[i] + " = ? where " + fields[i] + " = ?");

                if (fields[i].equals("creditlimit")) {
                    pst.setDouble(1, Double.parseDouble(userData.get(fields[i])));
                } else {
                    pst.setString(1, userData.get(fields[i]));
                }
                pst.setString(2, "ahmed");

                int update = pst.executeUpdate();

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }

    public static int checkStatus(HttpSession session) {
        if (session.getAttribute("usertype") != null) {
            if (session.getAttribute("usertype").equals("user")) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return 0;
        }

    }

}
