/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import org.bson.Document;

/**
 *
 * @author eslam
 */
public class DataBaseConnector implements ServletContextListener {
    private final String url = "jdbc:postgresql:souq_web";
    private final String user = "postgres";
    private final String password = "new";
    
    public static MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
    public static  MongoDatabase database = null;
    public static MongoCollection<Document> coll = null ;
    public static Connection connection = null;
    public static PreparedStatement preparedStatment = null;
     public static ResultSet result = null;
    private String sqlCommand;
    char[] ch = null;
    Statement state;


    @Override
    public void contextInitialized(ServletContextEvent sce) {
         database = mongoClient.getDatabase("souq_web");
         coll = database.getCollection("feedbacks");
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
        
          try {
              state.close();
              connection.close();
          } catch (SQLException ex) {
              Logger.getLogger(DataBaseConnector.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
}

