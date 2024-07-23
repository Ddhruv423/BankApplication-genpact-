package bank.controllers;

import java.io.IOException;

import bank.dao.withdrawDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/withdrawServlet")
public class withdrawServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String amountStr = request.getParameter("amount");
        String accNoStr = request.getParameter("accNo");
        String action = request.getParameter("action");

        try {
            int amount = Integer.parseInt(amountStr);
            int accNo = Integer.parseInt(accNoStr);

            boolean result = false;
            if ("withdraw".equals(action)) {
                result = withdrawDao.withdraw(amount, accNo); // Corrected DAO class name
            } else if ("deposit".equals(action)) {
                result = withdrawDao.deposit(amount, accNo); // Corrected DAO class name
            }

            response.setContentType("text/html");
            response.getWriter().println("<html><body>");
            response.getWriter().println((action.equals("withdraw") ? "Withdrawal" : "Deposit") + " " + (result ? "successful" : "failed"));
            response.getWriter().println("</body></html>");
        } catch (NumberFormatException e) {
            response.setContentType("text/html");
            response.getWriter().println("<html><body>");
            response.getWriter().println("Invalid input. Please enter numeric values.");
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