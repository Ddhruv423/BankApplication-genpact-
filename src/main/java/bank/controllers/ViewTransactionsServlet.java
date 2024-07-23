package bank.controllers;

import java.io.IOException;
import java.util.List;

import bank.dao.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import bank.model.*;

@WebServlet("/ViewTransactionsServlet")
public class ViewTransactionsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accountNumber = (String) request.getSession().getAttribute("accountNumber");

        TransactionDAO transactionDAO = new TransactionDAO();
        List<Transaction> transactions = transactionDAO.getLast10Transactions(accountNumber);

        request.setAttribute("transactions", transactions);
        request.getRequestDispatcher("viewTransactions.jsp").forward(request, response);
    }
}
