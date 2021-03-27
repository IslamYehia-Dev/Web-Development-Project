package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class dbconnection implements ServletContextListener {

    public static Connection con;

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        try {

            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/souq_web", "postgres", "hoksha");
            Statement smt = con.createStatement();
        } catch (SQLException ex) {
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(dbconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

}
