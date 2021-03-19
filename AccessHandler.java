/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import DB.User;
/**
 *
 * @author Al Badr
 */
public class AccessHandler {

    public static int verifyLogin(String username, String password) {
        boolean invalidLogin = false;
        boolean adminLogin = false;
        String fetchedName = "";
        ResultSet result;

        try {

            PreparedStatement pst2 = DB.DataBaseConnector.connection.prepareStatement("select uname,type from users where uname = ? and password = ?");
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
    public static int registerUser(User user){
            int currentId = 0;
    int updateStatus = 0;
    boolean invalidUser = false;


    try {

        PreparedStatement pst = DB.DataBaseConnector.connection.prepareStatement("select MAX(id) from users");

        ResultSet result = pst.executeQuery();
        while (result.next()) {

            currentId = result.getInt(1);
        }
        currentId++;

        PreparedStatement pst2 = DB.DataBaseConnector.connection.prepareStatement("select uname from users");
        result = pst2.executeQuery();
        while (result.next()) {
            if (result.getString(1).equals(user.uname)) {
                invalidUser = true;

            }

        }

        if (!invalidUser) {
            pst = DB.DataBaseConnector.connection.prepareStatement("insert into users values(?,?,?,?,?,?,?,?,?)");
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
        user.id=currentId;
        return 1;
        

    } 
    else{
    return 0;
    }
    }
}
