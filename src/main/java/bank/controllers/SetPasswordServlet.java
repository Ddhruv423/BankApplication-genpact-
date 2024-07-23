package bank.controllers;

import java.io.IOException;
import java.sql.SQLException;
import bank.dao.SetPasswordDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SetPasswordServlet")
public class SetPasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long accountNumber = Long.parseLong(request.getParameter("accountNumber"));
        String tempPassword = request.getParameter("tempPassword");
        String newPassword = request.getParameter("newPassword");

        response.setContentType("text/html");

        try {
            if (SetPasswordDAO.verifyTempPassword(accountNumber, tempPassword)) {
            	SetPasswordDAO.updatePassword(accountNumber, newPassword);
                response.getWriter().println("Password updated successfully. <a href='customerlogin.jsp'>Login here</a>");
            } else {
                response.getWriter().println("Invalid temporary password.");
            }
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }
}
