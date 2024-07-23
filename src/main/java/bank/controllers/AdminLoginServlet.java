package bank.controllers;

import java.io.IOException;

import bank.dao.AdminDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AdminDao adminDAO;

    public void init() {
        setAdminDAO(new AdminDao());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        handleRequest(request, response);
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean valid = adminDAO.validate(username, password);

        if (valid) {
            response.sendRedirect("adminloginsuccess.jsp");
        } else {
            response.sendRedirect("adminloginfailure.jsp");
        }
    }

	public AdminDao getAdminDAO() {
		return adminDAO;
	}

	public void setAdminDAO(AdminDao adminDAO) {
		this.adminDAO = adminDAO;
	}
}
