package bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import bank.model.Transaction;
import util.DataBaseUtil;

public class AddTranscationDAO {

    // Method to add a transaction
    public static void addTransaction(Transaction transaction) throws SQLException {
        String query = "INSERT INTO transcations (Accno, Amount, Description, Date) VALUES (?, ?, ?, ?)";

        try (Connection connection = DataBaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setLong(1, transaction.getAccno());
            preparedStatement.setDouble(2, transaction.getAmount());
            preparedStatement.setString(3, transaction.getDescription());
            preparedStatement.setDate(4, new java.sql.Date(transaction.getDate().getTime()));

            preparedStatement.executeUpdate();
        }
    }

    // Method to update the balance
    public static void updateBalance(long accountNumber, double newBalance) throws SQLException {
        String query = "UPDATE customer SET Balance = ? WHERE Accno = ?";

        try (Connection connection = DataBaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setDouble(1, newBalance);
            preparedStatement.setLong(2, accountNumber);

            preparedStatement.executeUpdate();
        }
    }

    // Method to get the current balance
    public static double getCurrentBalance(long accountNumber) throws SQLException {
        String query = "SELECT Balance FROM customer WHERE Accno = ?";

        try (Connection connection = DataBaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setLong(1, accountNumber);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getDouble("Balance");
            } else {
                throw new SQLException("Account not found.");
            }
        }
    }
}
