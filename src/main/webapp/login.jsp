<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            text-align: center;
            margin-top: 100px;
            background: linear-gradient(to right, #ACB6E5, #fda085);
            color: #000000;
        }
        h1 {
            font-size: 40px;
            margin-bottom: 50px;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
        }
        .button {
            display: inline-block;
            padding: 15px 40px;
            margin: 10px;
            font-size: 20px;
            font-weight: bold;
            cursor: pointer;
            text-decoration: none;
            color: #000000;
            background-color: #E0FFFF;
            border: 2px solid #E0FFFF;
            border-radius: 50px;
            transition: all 0.3s ease;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
        .button:hover {
            background-color: #F8F8FF;
            border-color: #F8F8FF;
        }
        .button-container {
            display: inline-block;
            margin-top: 30px;
        }
        .image-container {
            margin-bottom: 50px;
        }
        .image-container img {
            max-width: 400px;
            height: 300px;
        }
    </style>
</head>
<body>
	<div class="image-container">
        <img src="https://i.postimg.cc/J4rX0j3x/i5.png" alt="Login Image">
    </div>
        <div class="subtitle">Please select your login type</div>
    
    <div class="button-container">
        <a href="adminlogin.jsp" class="button">Admin Login</a>
        <a href="customerlogin.jsp" class="button">Customer Login</a>
    </div>

</body>
</html>
