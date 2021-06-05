package com.iti.OrderAPI.OrderStatusAPI.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DataBaseConnector implements ServletContextListener {
    private final String url = "jdbc:postgresql:souq_web";
    private final String user = "postgres";
    private final String password = "new";
    public static Connection connection = null;
     private Statement state;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
        try {
            state.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
		
	}

}
