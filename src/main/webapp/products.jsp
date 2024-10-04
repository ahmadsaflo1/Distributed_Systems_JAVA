<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="se.kth.ahmad_nedal.distributed_systems_java.BO.Product" %>
<%@ page import="java.util.List" %>


<%
    List<Product> products = (List<Product>) request.getAttribute("products");
%>
<html>
<head>
    <title>Products</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
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
            background-color: #28a745;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .product-card input[type="submit"]:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
<h2>Available Products</h2>
<div class="container">
    <% if (products != null && !products.isEmpty()) { %>
    <% for (Product product : products) { %>
    <div class="product-card">
        <h3><%= product.getName() %></h3>
        <p><%= product.getPrice() %> kr</p>
        <form action="cart" method="post">
            <input type="hidden" name="productId" value="<%= product.getId() %>">
            <input type="hidden" name="productName" value="<%= product.getName() %>">
            <input type="hidden" name="productPrice" value="<%= product.getPrice() %>">
            <input type="submit" value="Lägg till i kundvagn">
        </form>
    </div>
    <% } %>
    <% } else { %>
    <p>Inga produkter tillgängliga för närvarande.</p>
    <% } %>
</div>
</body>
</html>
