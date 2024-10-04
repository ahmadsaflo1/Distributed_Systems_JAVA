<%@ page import="java.util.List" %>
<%@ page import="se.kth.ahmad_nedal.distributed_systems_java.BO.Product" %>
<%
    // Hämta kundvagnslistan från sessionen
    List<Product> cart = (List<Product>) session.getAttribute("cart");
    double total = 0; // Variabel för att hålla reda på totala priset
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Cart</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 60%;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            color: #333;
            border-bottom: 2px solid #4CAF50;
            padding-bottom: 10px;
            margin-bottom: 20px;
        }

        ul {
            list-style: none;
            padding: 0;
        }

        li {
            padding: 15px;
            border-bottom: 1px solid #ddd;
            display: flex;
            justify-content: space-between;
            font-size: 18px;
        }

        li:last-child {
            border-bottom: none;
        }

        .total {
            font-size: 22px;
            font-weight: bold;
            text-align: right;
            margin-top: 20px;
        }

        .empty-cart {
            text-align: center;
            font-size: 18px;
            color: #999;
            margin-top: 20px;
        }

        .checkout-btn {
            display: block;
            width: 100%;
            text-align: center;
            background-color: #4CAF50;
            color: white;
            padding: 10px 0;
            font-size: 18px;
            font-weight: bold;
            text-decoration: none;
            margin-top: 20px;
            border-radius: 5px;
        }

        .checkout-btn:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Your Cart</h2>
    <ul>
        <% if (cart != null && !cart.isEmpty()) { %>
        <% for (Product product : cart) { %>
        <li>
            <span><%= product.getName() %></span>
            <span>$<%= String.format("%.2f", product.getPrice()) %></span>
        </li>
        <% total += product.getPrice(); %>
        <% } %>
        <% } else { %>
        <p class="empty-cart">Your cart is empty.</p>
        <% } %>
    </ul>

    <% if (cart != null && !cart.isEmpty()) { %>
    <div class="total">Total: $<%= String.format("%.2f", total) %></div>
    <a href="checkout.jsp" class="checkout-btn">Proceed to Checkout</a>
    <% } %>
</div>
</body>
</html>

