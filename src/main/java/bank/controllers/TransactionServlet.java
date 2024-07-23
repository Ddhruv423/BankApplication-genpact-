package bank.controllers;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import bank.dao.AddTranscationDAO;
import bank.model.Transaction;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;

@WebServlet("/TransactionServlet")
public class TransactionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AddTranscationDAO transactionDAO = new AddTranscationDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long accountNumber = Long.parseLong(request.getParameter("accountNumber"));
        double amount = Double.parseDouble(request.getParameter("amount"));
        String transactionType = request.getParameter("transactionType");

        try {
            // Get the current balance
            double currentBalance = AddTranscationDAO.getCurrentBalance(accountNumber);

            // Calculate the new balance
            double newBalance;
            if ("deposit".equalsIgnoreCase(transactionType)) {
                newBalance = currentBalance + amount;
            } else if ("withdraw".equalsIgnoreCase(transactionType)) {
                newBalance = currentBalance - amount;
            } else {
                throw new IllegalArgumentException("Invalid transaction type.");
            }

            // Update the balance in the customer table
            AddTranscationDAO.updateBalance(accountNumber, newBalance);

            // Create a transaction record
            Transaction transaction = new Transaction();
            transaction.setAccno(accountNumber);
            transaction.setDate(new Date(System.currentTimeMillis()));
            transaction.setDescription(transactionType.toUpperCase());
            transaction.setAmount(amount);

            // Add the transaction record
            AddTranscationDAO.addTransaction(transaction);

            response.sendRedirect("transactionSuccess.html");

        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        } catch (NumberFormatException e) {
            response.setContentType("text/html");
            response.getWriter().println("Invalid input. Please enter numeric values.");
        } catch (Exception e) {
            e.printStackTrace();
            response.setContentType("text/html");
            response.getWriter().println("An error occurred during the process.");
        }
    }

	public AddTranscationDAO getTransactionDAO() {
		return transactionDAO;
	}

	public void setTransactionDAO(AddTranscationDAO transactionDAO) {
		this.transactionDAO = transactionDAO;
	}
}
