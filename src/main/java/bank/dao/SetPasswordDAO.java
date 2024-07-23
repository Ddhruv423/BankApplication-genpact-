package bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.DataBaseUtil;

public class SetPasswordDAO {

    // Method to verify temporary password
    public static boolean verifyTempPassword(long accountNumber, String tempPassword) throws SQLException {
        String query = "SELECT COUNT(*) FROM customer WHERE Accno = ? AND Temppassword = ?";

        try (Connection connection = DataBaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setLong(1, accountNumber);
            preparedStatement.setString(2, tempPassword);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) == 1;
            } else {
                return false;
            }
        }
    }

    // Method to update the password
    public static void updatePassword(long accountNumber, String newPassword) throws SQLException {
        String query = "UPDATE customer SET Temppassword = ? WHERE Accno = ?";

        try (Connection connection = DataBaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, newPassword);
            preparedStatement.setLong(2, accountNumber);

            preparedStatement.executeUpdate();
        }
    }

    // Method to verify login credentials
    public static boolean verifyLogin(long accountNumber, String password) throws SQLException {
        String query = "SELECT COUNT(*) FROM customer WHERE Accno = ? AND Temppassword = ?";

        try (Connection connection = DataBaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setLong(1, accountNumber);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) == 1;
            } else {
                return false;
            }
        }
    }
}
