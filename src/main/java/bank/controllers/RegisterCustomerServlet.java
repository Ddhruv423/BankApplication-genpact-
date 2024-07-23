package bank.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.DataBaseUtil;

@WebServlet("/RegisterCustomerServlet")
public class RegisterCustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Redirect to an error page or display a friendly message
        response.sendRedirect("Error1.jsp"); // Redirect to a custom error page
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String Fullname = request.getParameter("Fullname");
        String Address = request.getParameter("Address");
        String Phoneno = request.getParameter("Phoneno");
        String Emailid = request.getParameter("Emailid");
        String DOB = request.getParameter("DOB");
        String Accno = request.getParameter("Accno");
        String Acctype = request.getParameter("Acctype");
        String Password = request.getParameter("Password");
        String Balance = request.getParameter("Balance");
        String Idproof = request.getParameter("Idproof");

        if (Fullname == null || Address == null || Phoneno == null || Emailid == null || DOB == null ||
                Accno == null || Acctype == null || Password == null || Balance == null || Idproof == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing parameters");
            return;
        }

        Connection conn = null;
        try {
            conn = DataBaseUtil.getConnection();

            String sql = "INSERT INTO customer (Fullname, Address, Phoneno, Emailid, DOB, Accno, Acctype, Password, Balance, Idproof) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, Fullname);
            stmt.setString(2, Address);
            stmt.setString(3, Phoneno);
            stmt.setString(4, Emailid);
            stmt.setString(5, DOB);
            stmt.setString(6, Accno); // Assuming accno is taken from the request
            stmt.setString(7, Acctype);
            stmt.setString(8, Password);
            stmt.setString(9, Balance); // Setting balance as string
            stmt.setString(10, Idproof);

            stmt.executeUpdate();

            response.sendRedirect("regsuccess.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("regfailure.jsp");
        } finally {
            DataBaseUtil.closeConnection(conn);
        }
    }
}
