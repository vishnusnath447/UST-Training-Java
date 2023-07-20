package org.example.ust.dao;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    /*
    * First thing is to connect the DB
    */
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private DBConnection(){}
    //load the driver class
    public static Connection getConnection() throws SQLException{
        //loading the driver
        //option 1 Class.forName() throws class not found
        //Class.forName("com.mysql.cj.jdbc.Driver"); replace it with (new Driver)

        //option 2 DriverManager.reg
        DriverManager.registerDriver(new Driver());
        Connection connection=DriverManager.getConnection(URL,USER,PASSWORD);
        return connection;
    }
}
