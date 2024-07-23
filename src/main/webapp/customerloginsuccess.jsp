<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f5f5f5;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background-color: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
            width: 300px;
        }
        .container h1 {
            margin-bottom: 20px;
            color: #333;
        }
        .button {
            display: block;
            margin: 15px auto;
            padding: 12px 20px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s ease;
            text-decoration: none;
            width: 100%;
            box-sizing: border-box;
        }
        .button:hover {
            background-color: #0056b3;
        }
        .success-message {
            display: none;
            color: #2ecc71;
            margin-bottom: 20px;
            font-size: 18px;
            font-weight: bold;
        }
        @keyframes blink {
            50% { background-color: #2ecc71; }
        }
    </style>
    <script>
        function showSuccessMessage() {
            var successMessage = document.getElementById('success-message');
            successMessage.style.display = 'block';
            document.body.style.animation = 'blink 1s';
            setTimeout(function() {
                document.body.style.animation = '';
            }, 500);
        }
        window.onload = showSuccessMessage;
    </script>
</head>
<body>
    <div class="container">
        <h1>Welcome Customer</h1>
        <div id="success-message" class="success-message">Login Successful</div>
        <a href="SetPassword.jsp" class="button">Reset Password</a>
        <a href="withdraw.jsp" class="button">Deposit Amount</a>
        <a href="withdraw.jsp" class="button">Withdraw Amount</a>
        <a href="DisplayCustomerDetails.jsp" class="button">Update Details</a>
        <a href="ViewTranscation.jsp" class="button">View Transcation</a>
        <a href="Closeaccount.jsp" class="button">Close Account</a>
    </div>
</body>
</html>
