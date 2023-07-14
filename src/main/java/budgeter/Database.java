package budgeter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.LocalDate;
import java.sql.Date;
import java.time.ZoneId;

public class Database {
    String create_db_query = "CREATE DATABASE IF NOT EXISTS budget";

    String create_transactions_table_query = "CREATE TABLE IF NOT EXISTS transactions (" +
            "id BIGINT(20) NOT NULL AUTO_INCREMENT," +
            "date DATE NOT NULL," +
            "weekStartDate DATE NOT NULL," +
            "total DOUBLE(20, 2) NULL DEFAULT 0.00," +
            "status SMALLINT(8) NOT NULL DEFAULT 1," +
            "hours FLOAT NULL DEFAULT NULL," +
            "created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP," +
            "plannedStart DATETIME NULL DEFAULT NULL," +
            "plannedEnd DATETIME NULL DEFAULT NULL," +
            "actualStart DATETIME NULL DEFAULT NULL," +
            "actualEnd DATETIME NULL DEFAULT NULL," +
            "PRIMARY KEY (id)," +
            "FOREIGN KEY (userId) REFERENCES users(id)" +
            ")";


    String create_tags_table_query = "CREATE TABLE tags (" +
            "id BIGINT(20) NOT NULL AUTO_INCREMENT," +
            "title VARCHAR(50) NOT NULL," +
            "description VARCHAR(900) NULL DEFAULT NULL," +
            "PRIMARY KEY (id)" +
            ")";

    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        String budgetDatabase = "Budgeting_Database";
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test3?useSSL=false",
                    "root", "root");
            stmt = con.createStatement();
            int status = stmt.executeUpdate("CREATE DATABASE " + budgetDatabase);
            if (status > 0) {
                System.out.println("Database is created successfully !!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
