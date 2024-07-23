package bank.controllers;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import bank.dao.AddTranscationDAO;
import bank.dao.withdrawDao;
import bank.model.Transaction;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/BankTransactionServlet")
public class BankTransactionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AddTranscationDAO transactionDAO = new AddTranscationDAO();
    private withdrawDao withdrawDao = new withdrawDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        long accountNumber = Long.parseLong(request.getParameter("accountNumber"));
        double amount = Double.parseDouble(request.getParameter("amount"));

        try {
            boolean result = false;
            if ("withdraw".equals(action) || "deposit".equals(action)) {
                // Handle withdrawal and deposit
                if ("withdraw".equals(action)) {
                    result = withdrawDao.withdraw((int)amount, (int)accountNumber);
                } else {
                    result = withdrawDao.deposit((int)amount, (int)accountNumber);
                }

                // Add transaction record
                Transaction transaction = new Transaction();
                transaction.setAccno(accountNumber);
                transaction.setDate(new Date(System.currentTimeMillis()));
                transaction.setDescription(action.toUpperCase());
                transaction.setAmount("withdraw".equals(action) ? -amount : amount);

                transactionDAO.addTransaction(transaction);

                response.setContentType("text/html");
                response.getWriter().println("<html><body>");
                response.getWriter().println((action.equals("withdraw") ? "Withdrawal" : "Deposit") + " " + (result ? "successful" : "failed"));
                response.getWriter().println("</body></html>");
            } else {
                response.setContentType("text/html");
                response.getWriter().println("<html><body>");
                response.getWriter().println("Invalid action specified.");
                response.getWriter().println("</body></html>");
            }
        } catch (NumberFormatException e) {
            response.setContentType("text/html");
            response.getWriter().println("<html><body>");
            response.getWriter().println("Invalid input. Please enter numeric values.");
            response.getWriter().println("</body></html>");
        } catch (SQLException e) {
            e.printStackTrace();
            response.setContentType("text/html");
            response.getWriter().println("<html><body>");
            response.getWriter().println("An error occurred during the database operation.");
            response.getWriter().println("</body></html>");
        } catch (Exception e) {
            e.printStackTrace();
            response.setContentType("text/html");
            response.getWriter().println("<html><body>");
            response.getWriter().println("An error occurred during the process.");
            response.getWriter().println("</body></html>");
        }
    }
}