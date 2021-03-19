/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

/**
 *
 * @author Al Badr
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Al Badr
 */
public class DataBaseConnector implements ServletContextListener {
      private final String url = "jdbc:postgresql:souq_web";
    private final String user = "postgres";
    private final String password = "new";

    public static Connection connection = null;
    public static PreparedStatement preparedStatment = null;
     public static ResultSet result = null;
    private String sqlCommand;
    char[] ch = null;
    Statement state;
    String nme = "";
    boolean checkname = true;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
        try {
            
            connection = DriverManager.getConnection(url, user, password);
            state = connection.createStatement();
            
        }
        catch(SQLException e){
        e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}

