package bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class withdrawDao {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/bankapp";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "SQLRootpassword";

    static Connection getConnection() {
        Connection conn = null;
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Create database connection
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static boolean withdraw(int amount, int accountNo) {
        String query = "UPDATE customer SET Balance = Balance - ? WHERE Accno = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, amount);
            pstmt.setInt(2, accountNo);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean deposit(int amount, int accountNo) {
        String query = "UPDATE customer SET Balance = Balance + ? WHERE Accno = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, amount);
            pstmt.setInt(2, accountNo);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
