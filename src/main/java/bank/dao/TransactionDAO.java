package bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bank.model.*;
import util.DataBaseUtil;

public class TransactionDAO {

    // Method to get the last 10 transactions
    public List<Transaction> getLast10Transactions(String accountNumber) {
        List<Transaction> transactions = new ArrayList<>();
        String query = "SELECT * FROM transactions WHERE Accno = ? ORDER BY Date DESC LIMIT 10";
        try (Connection conn = DataBaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
             
            pstmt.setString(1, accountNumber);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Transaction transaction = new Transaction();
                    transaction.setDate(rs.getDate("Date"));
                    transaction.setDescription(rs.getString("Description"));
                    transaction.setAmount(rs.getDouble("Amount"));
                    transactions.add(transaction);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }

    // Method to get all transactions for a specific account number
    public List<Transaction> getAllTransactions(String accountNumber) {
        List<Transaction> transactions = new ArrayList<>();
        String query = "SELECT * FROM transactions WHERE Accno = ? ORDER BY Date DESC";
        try (Connection conn = DataBaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
             
            pstmt.setString(1, accountNumber);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Transaction transaction = new Transaction();
                    transaction.setDate(rs.getDate("Date"));
                    transaction.setDescription(rs.getString("Description"));
                    transaction.setAmount(rs.getDouble("Amount"));
                    transactions.add(transaction);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }
}
