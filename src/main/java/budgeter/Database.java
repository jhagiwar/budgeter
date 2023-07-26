package budgeter;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.LocalDate;
import java.sql.Date;
import java.time.ZoneId;


public class Database {
    public String create_db_query = "CREATE DATABASE IF NOT EXISTS budget";

    public String create_transactions_table_query = "CREATE TABLE IF NOT EXISTS transactions (" +
            "id BIGINT(20) NOT NULL AUTO_INCREMENT," +
            "date DATE NOT NULL," +
            "weekStartDate DATE NOT NULL," +
            "total DOUBLE(20, 2) NOT NULL," +
            "categoryId VARCHAR(50) NOT NULL," +
            "paymentType VARCHAR(50) NOT NULL," +
            "title VARCHAR(50) NOT NULL," +
            "vendor VARCHAR(50) NOT NULL," +
            "PRIMARY KEY (id)," +
            ")";

    public static void create_transaction_table() {
        // load and register JDBC driver for MySQL
        String url = "jdbc:mysql://localhost:3306/budget";
        String username = "root";
        String password = "root";

        System.out.println("Connecting database...");

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS transactions (" +
                    "id BIGINT(20) NOT NULL AUTO_INCREMENT," +
                    "date DATE NOT NULL," +
                    "weekStartDate DATE NOT NULL," +
                    "total DOUBLE(20, 2) NOT NULL," +
                    "categoryId VARCHAR(50) NOT NULL," +
                    "paymentType VARCHAR(50) NOT NULL," +
                    "title VARCHAR(50) NOT NULL," +
                    "vendor VARCHAR(50) NOT NULL," +
                    "PRIMARY KEY (id)" +
                    ")";
            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insert_transaction() {
        // load and register JDBC driver for MySQL
        String url = "jdbc:mysql://localhost:3306/budget";
        String username = "root";
        String password = "root";

        System.out.println("Connecting database...");

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            //        `id`, `date`, `weekStartDate`, `total`, `categoryId`, `paymentType`, `title`, `vendor`
            String sql = "INSERT INTO transactions (date,weekStartDate,total,categoryId,paymentType,title,vendor)";
            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws SQLException {
//        CREATE TABLE IF THERE ISNT ONE
        create_transaction_table();

    }
}
