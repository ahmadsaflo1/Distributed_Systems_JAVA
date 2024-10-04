<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="se.kth.ahmad_nedal.distributed_systems_java.BO.Product" %>
<%@ page import="java.util.List" %>
<%
    List<Product> products = (List<Product>) session.getAttribute("products");
%>

<html>
<head>
    <title>Products</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .navbar {
            width: 100%;
            background-color: #333;
            overflow: hidden;
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 14px 20px;
        }

        .navbar h1 {
            color: white;
            margin: 0;
            font-size: 24px;
        }

        .navbar .cart-btn {
            background-color: #28a745;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
            font-size: 16px;
            margin-right: 40px;
        }

        .navbar .cart-btn img {
            width: 20px;
            height: 20px;
            vertical-align: middle;

        }

        h2 {
            text-align: center;
            padding: 20px;
            color: #333;
        }

        .container {
            width: 80%;
            margin: 0 auto;
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
        }

        .product-card {
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 8px;
            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
            margin: 20px;
            padding: 15px;
            width: 250px;
            text-align: center;
        }

        .product-card h3 {
            margin-bottom: 10px;
            color: #555;
        }

        .product-card p {
            color: #888;
            font-size: 18px;
        }

        .product-card form {
            margin-top: 10px;
        }

        .product-card input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .product-card input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="navbar">
    <h1>Products List</h1>
    <a href="cart.jsp" class="cart-btn">
        <img src="https://cdn-icons-png.flaticon.com/512/126/126083.png" alt="Cart Icon">
    </a>
</div>
<h2>Available Products</h2>
<div class="container">
    <% if (products != null && !products.isEmpty()) { %>
    <% for (Product product : products) { %>
    <div class="product-card">
        <h3><%= product.getName() %>
        </h3>
        <p><%= product.getPrice() %> kr</p>
        <form action="add-to-cart" method="post">
            <input type="hidden" name="productId" value="<%= product.getId() %>">
            <input type="hidden" name="productName" value="<%= product.getName() %>">
            <input type="hidden" name="productPrice" value="<%= product.getPrice() %>">
            <input type="submit" value="Add to cart">
        </form>
    </div>
    <% } %>
    <% } else { %>
    <p>No products currently available</p>
    <% } %>
</div>
</body>
</html>
