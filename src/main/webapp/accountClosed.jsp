<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Account Closed</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background-color: #fff;
            padding: 20px 30px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            text-align: center;
            max-width: 500px;
            width: 100%;
        }
        h1 {
            color: #28a745;
            margin-bottom: 20px;
        }
        p {
            color: #343a40;
            font-size: 16px;
        }
        .success-icon {
            font-size: 50px;
            color: #28a745;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="success-icon">&check;</div>
        <h1>Account Closed Successfully</h1>
        <p>The account no longer exists.</p>
    </div>
</body>
</html>