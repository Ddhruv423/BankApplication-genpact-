package bank.controllers;

import java.io.IOException;
import java.util.Random;

import bank.dao.CustomerRegistrationDAO;
import bank.model.Customer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CustomerRegisterServlet")
public class CustomerRegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Fullname = request.getParameter("Fullname");
        String Address = request.getParameter("Address");
        String PhonenoStr = request.getParameter("Phoneno");
        String Emailid = request.getParameter("Emailid");
        String DOB = request.getParameter("DOB");
        String Acctype = request.getParameter("Acctype");
        String BalanceStr = request.getParameter("Balance");
        String Idproof = request.getParameter("Idproof");

        response.setContentType("text/html");

        // Validate inputs
        if (Fullname == null || Address == null || PhonenoStr == null || Emailid == null ||
            DOB == null || Acctype == null || BalanceStr == null || Idproof == null ||
            Fullname.isEmpty() || Address.isEmpty() || PhonenoStr.isEmpty() || Emailid.isEmpty() ||
            DOB.isEmpty() || Acctype.isEmpty() || BalanceStr.isEmpty() || Idproof.isEmpty()) {
            response.getWriter().println("All fields are required.");
            return;
        }

        try {
            long Phoneno = Long.parseLong(PhonenoStr);
            float Balance = Float.parseFloat(BalanceStr);
            long Accno = generateAccountNumber();
            String Temppassword = generateTemppassword();

            Customer customer = new Customer();
            // Assuming Customer class has a suitable constructor or setters
            customer.setFullname(Fullname);
            customer.setAddress(Address);
            customer.setPhoneno(Phoneno);
            customer.setEmailid(Emailid);
            customer.setDOB(DOB);
            customer.setAcctype(Acctype);
            customer.setBalance(Balance);
            customer.setIdproof(Idproof);
            customer.setAccno(Accno);
            customer.setTemppassword(Temppassword);

            CustomerRegistrationDAO customerDAO = new CustomerRegistrationDAO();
            boolean isRegistered = customerDAO.registerCustomer(customer);

            if (isRegistered) {
                response.getWriter().println("Customer registered successfully. Account Number: " + Accno + ", Temporary Password: " + Temppassword);
            } else {
                response.getWriter().println("Customer registration failed.");
            }
        } catch (NumberFormatException e) {
            response.getWriter().println("Invalid number format for phone number or balance.");
        } catch (Exception e) {
            response.getWriter().println("An unexpected error occurred.");
            e.printStackTrace();
        }
    }

    private long generateAccountNumber() {
        return new Random().nextLong(1000000000L, 9999999999L);
    }

    private String generateTemppassword() {
        return Long.toHexString(Double.doubleToLongBits(Math.random())).substring(8);
    }
}
