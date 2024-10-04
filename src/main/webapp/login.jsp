<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Login Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            height: 100vh; /* Full höjd */
            display: flex; /* Använd flexbox */
            justify-content: center; /* Centrera horisontellt */
            align-items: center; /* Centrera vertikalt */
        }

        .header {
            position: absolute;
            top: 20px;
            width: 100%;
            text-align: center;
        }

        .container {
            background-color: #fff;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            width: 300px; /* Sätt en bredd på formuläret */
            text-align: center; /* Centrera text i formuläret */
        }

        h2 {
            color: #333;
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 5px;
        }

        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
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
<div class="header">
    <h2>Logga in</h2>
</div>
<div class="container">
    <form action="login" method="post">
        <label for="username">Användarnamn:</label><br>
        <input type="text" id="username" name="username" required><br><br>
        <label for="password">Lösenord:</label><br>
        <input type="password" id="password" name="password" required><br><br>
        <input type="submit" value="Login">
    </form>
</div>
</body>
</html>
