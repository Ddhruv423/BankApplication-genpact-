package bank.controllers;

import java.io.IOException;

import bank.dao.customerdao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CustomerLoginServlet")
public class CustomerLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private customerdao customerDAO;

    public void init() {
        setCustomerDAO(new customerdao());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        handleRequest(request, response);
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean valid = bank.dao.customerdao.validate(username, password);

        if (valid) {
            response.sendRedirect("customerloginsuccess.jsp");
        } else {
            response.sendRedirect("customerloginfailure.jsp");
        }
    }

	public customerdao getCustomerDAO() {
		return customerDAO;
	}

	public void setCustomerDAO(customerdao customerDAO) {
		this.customerDAO = customerDAO;
	}
}
