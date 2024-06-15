package Context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {

    protected Connection connection;
    
    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/SWP391";
            String username = "root";
            String password = "kayboy94";
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }

    public DBContext() {
        
        try {
            // Edit URL , username, password to authenticate with your MS SQL Server

            String url = "jdbc:mysql://localhost:3306/SWP391";
            String username = "root";
            String password = "kayboy94";
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
