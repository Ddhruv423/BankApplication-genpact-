package bank.dao;
import java.sql.*;

import bank.model.Customer;
public class CustomerRegistrationDAO {
	

	
	    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/bankapp";
	    private static final String JDBC_USERNAME = "root";
	    private static final String JDBC_PASSWORD = "SQLRootpassword";

	    public boolean registerCustomer(Customer customer) {
	        boolean isRegistered = false;

	        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD)) {
	            String sql = "INSERT INTO customer (Fullname, Address, Phoneno, Emailid, Accno, Balance, DOB, Idproof, Accno, Temppassword) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	            try (PreparedStatement statement = connection.prepareStatement(sql)) {
	                statement.setString(1, customer.getFullname());
	                statement.setString(2, customer.getAddress());
	                statement.setLong(3, customer.getPhoneno());
	                statement.setString(4, customer.getEmailid());
	                statement.setString(7, customer.getDOB());
	                statement.setString(5, customer.getAcctype());
	                statement.setFloat(6, customer.getBalance());
	                statement.setString(8, customer.getIdproof());
	                statement.setLong(9, customer.getAccno());
	                statement.setString(10, customer.getTemppassword());

	                int rowsInserted = statement.executeUpdate();
	                if (rowsInserted > 0) {
	                    isRegistered = true;
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return isRegistered;
	    }
	}


