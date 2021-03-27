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

/**
 *
 * @author eslam
 */
public class AccessHandler {

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

    public static int verifyLogin(String username, String password) {
        boolean invalidLogin = false;
        boolean adminLogin = false;
        String fetchedName = "";
        ResultSet result;

        try {

            PreparedStatement pst2 = DataBaseConnector.connection.prepareStatement("select uname,type from users where uname = ? and password = ?");
            pst2.setString(1, username);
            pst2.setString(2, password);
            result = pst2.executeQuery();
            while (result.next()) {

                if (result.getBoolean(2) == true) {
                    adminLogin = true;
                }
                fetchedName = result.getString(1);

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
            return 1;

        } else {
            return 0;
        }
    }

    public static HashMap<Integer, Product> hashProducts(List<Product> prodCart) {
        HashMap<Integer, Product> myHash = new HashMap<Integer, Product>();
        // iterate - init - increment 
        prodCart.forEach((Product x) -> {
            if (myHash.get(x.id) == null) {
                x.orderedQuantity = 1;
                myHash.put(x.id, x);
            } else {
                myHash.get(x.id).orderedQuantity += 1;
            }
        });

        return myHash;
    }

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
                categories.add(new Category(rs.getInt("category_id"),rs.getString("cat_name")));
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
}
