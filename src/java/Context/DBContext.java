package Context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {

    protected Connection connection;

    public DBContext() {
        
        try {
            // Edit URL , username, password to authenticate with your MS SQL Server

<<<<<<< HEAD
            String url = "jdbc:mysql://localhost:3306/swp391";
            String username = "root";
            String password = "Hoang2004@";
=======
            String url = "jdbc:mysql://localhost:3306/SWP391";
            String username = "root";
            String password = "123456";
>>>>>>> a937313c36f24afc4cfc60197044e7de2c99093a
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        DBContext dbContext = new DBContext();
        System.out.println(dbContext.connection != null ? "Connection successful" : "Connection failed");

    }
}