package bank.controllers;

import java.io.IOException;

import bank.dao.CloseAccountDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/CloseAccountServlet")
public class CloseAccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accountNumber = request.getParameter("accno");
        
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Account number is required");
            return;
        }
        
        CloseAccountDAO accountDAO = new CloseAccountDAO();
        
        if (accountDAO.isAccountBalanceZero(accountNumber)) {
            if (accountDAO.deleteAccount(accountNumber)) {
                response.sendRedirect("accountClosed.jsp"); // Redirect to a success page
            } else {
                response.sendRedirect("error.jsp"); // Redirect to a generic error page
            }
        } else {
            response.sendRedirect("balanceNotZero.jsp"); // Redirect to a balance not zero page
        }
    }
}
