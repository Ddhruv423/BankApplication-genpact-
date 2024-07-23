<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Login</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background: linear-gradient(135deg, #74ebd5, #ACB6E5);
            margin: 0;
        }
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            gap: 100px; /* Adjust the gap between columns as needed */
        }
        .login-form {
            background-color: #fff;
            padding: 40px 30px;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            width: 350px;
            text-align: center;
            transition: transform 0.3s ease;
            position: relative;
        }
        .login-form:hover {
            transform: scale(1.05);
        }
        .login-form h2 {
            margin-bottom: 30px;
            font-size: 28px;
            color: #333;
            position: relative;
        }
        .login-form h2::after {
            content: '';
            width: 50px;
            height: 3px;
            background-color: #28a745;
            position: absolute;
            bottom: -10px;
            left: 50%;
            transform: translateX(-50%);
        }
        .input-group {
            margin-bottom: 20px;
            text-align: left;
        }
        .input-group label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
            color: #555;
        }
        .input-group input {
            width: calc(100% - 20px);
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 16px;
            box-sizing: border-box;
        }
        .button {
            width: 100%;
            padding: 12px 0;
            font-size: 18px;
            cursor: pointer;
            text-decoration: none;
            color: #fff;
            background-color: #28a745;
            border: none;
            border-radius: 5px;
            transition: background-color 0.3s, transform 0.3s;
        }
        .button:hover {
            background-color: #218838;
            transform: translateY(-3px);
        }
        .button:active {
            transform: translateY(0);
        }
        .login-form::before {
            content: '';
            width: 100%;
            height: 5px;
            background: linear-gradient(135deg, #74ebd5, #ACB6E5);
            position: right;
            top: 0;
            left: 0;
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
        }
        .image-container img {
            border-radius: 10px;
            max-width: 500px;
            height: auto;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="image-container">
            <img src="https://i.postimg.cc/QdHFwTTd/admin.png" alt="AdminLogin Image">
        </div>
        <div class="login-form">
            <h2>Admin Login</h2>
            <form action="AdminLoginServlet" method="post">
                <div class="input-group">
                    <label for="username">Username:</label>
                    <input type="text" id="username" name="username" required>
                </div>
                <div class="input-group">
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" required>
                </div>
                <button type="submit" class="button">Login</button>
            </form>
        </div>
    </div>
</body>
</html>
