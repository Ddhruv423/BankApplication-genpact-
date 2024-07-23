<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Banking Operations</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f8ff;
            margin: 0;
            padding: 20px;
        }
        h2 {
            color: #2f4f4f;
        }
        form {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            margin: auto;
        }
        label {
            display: block;
            margin: 10px 0 5px;
        }
        input[type="text"], input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin: 5px 0 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .radio-label {
            display: inline-block;
            margin-right: 10px;
        }
        input[type="radio"] {
            margin-right: 5px;
        }
    </style>
</head>
<body>
    <h2>Banking Operations</h2>
    <% 
        String username = (String) session.getAttribute("Username");
        System.out.println("Username retrieved from session: " + username); // Debug statement
        if (username == null) {
            out.println("<h2>Welcome, guest</h2>");
        } else {
            out.println("<h2>Welcome, " + username + "</h2>");
        }
    %>
    <form action="TransactionServlet" method="post">
        <label for="accountNumber">Account Number:</label>
        <input type="text" id="accountNumber" name="accountNumber" required><br><br>
        
        <label for="amount">Amount:</label>
        <input type="number" id="amount" name="amount" step="0.01" required><br><br>
        
        <label for="transactionType">Transaction Type:</label>
        <select id="transactionType" name="transactionType" required>
            <option value="deposit">Deposit</option>
            <option value="withdraw">Withdraw</option>
        </select><br><br>
        
        <input type="submit" value="Submit Transaction">
    </form>
    </body>
</html>
