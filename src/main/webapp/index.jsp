<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Main Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            text-align: center;
        }

        .container {
            background-color: #fff;
            padding: 40px;
            border: 1px solid #ccc;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            width: 400px;
        }

        h1 {
            color: #333;
            font-size: 32px;
            margin-bottom: 20px;
        }

        p {
            color: #555;
            font-size: 18px;
            margin-bottom: 30px;
        }

        .login-btn {
            background-color: #333; /* Mörkgrå färg */
            color: white;
            padding: 15px 30px;
            font-size: 18px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
        }

        .login-btn:hover {
            background-color: #555; /* Lite ljusare grå vid hover */
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Welcome</h1>
    <p>Welcome to our website. Click the button below to login</p>
    <a href="login.jsp" class="login-btn">Login</a>
</div>
</body>
</html>