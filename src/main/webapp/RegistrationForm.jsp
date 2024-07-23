<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Customer Registration</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input[type="text"], input[type="email"], input[type="number"], input[type="date"], select {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <form action="CustomerRegisterServlet" method="post">
        <h2>Register Customer</h2>
        <label for="Fullname">Full Name:</label>
        <input type="text" id="Fullname" name="Fullname" required>
        
        <label for="Address">Address:</label>
        <input type="text" id="Address" name="Address" required>
        
        <label for="mobileNo">Phone No:</label>
        <input type="text" id="mobileNo" name="mobileNo" required>
        
        <label for="email">Email ID:</label>
        <input type="email" id="email" name="email" required>
        
        <label for="accountType">Type of Account:</label>
        <select id="accountType" name="accountType">
            <option value="Saving Account">Saving Account</option>
            <option value="Current Account">Current Account</option>
        </select>
        
        <label for="initialBalance">Initial Balance:</label>
        <input type="number" id="initialBalance" name="initialBalance" min="1000" required>
        
        <label for="dob">Date of Birth:</label>
        <input type="date" id="dob" name="dob" required>
        
        <label for="idProof">ID Proof:</label>
        <input type="text" id="idProof" name="idProof" required>
        
        <input type="submit" value="Register">
    </form>
</body>
</html>
