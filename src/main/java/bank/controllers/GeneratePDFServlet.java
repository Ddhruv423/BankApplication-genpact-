package bank.controllers;

import java.io.IOException;
import java.util.List;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import bank.dao.TransactionDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import bank.model.Transaction;

@WebServlet("/GeneratePDFServlet")
public class GeneratePDFServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accountNumber = (String) request.getSession().getAttribute("accountNumber");

        TransactionDAO transactionDAO = new TransactionDAO();
        List<Transaction> transactions = transactionDAO.getLast10Transactions(accountNumber);

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=transactions.pdf");

        try (OutputStream os = response.getOutputStream();
        	     PdfWriter writer = new PdfWriter(os);
        	     PdfDocument pdf = new PdfDocument(writer);
        	     Document document = new Document(pdf)) {

        	    document.add(new Paragraph("Last 10 Transactions"));
        	    for (Transaction transaction : transactions) {
        	        document.add(new Paragraph("Date: " + transaction.getDate().toString()));
        	        document.add(new Paragraph("Description: " + transaction.getDescription()));
        	        document.add(new Paragraph("Amount: " + transaction.getAmount().toString()));
        	        document.add(new Paragraph(" "));
        	    }
        	} catch (IOException e) {
        	    e.printStackTrace();
        	    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error generating PDF");
        	}

        } catch (IOException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error generating PDF");
        }
    }
}