<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Shopping Cart</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <link rel="stylesheet" href="../assets/vendor/glightbox/css/glightbox.min.css">
</head>
<body>
<div class="container">
  <h1>Shopping Cart</h1>
  <table class="table">
    <thead>
    <tr>
      <th>Name</th>
      <th>Price</th>
      <th>Stock Quantity</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${cartItems}" var="product">
      <tr>
        <td>${product.name}</td>
        <td>${product.price}</td>
        <td>${product.stockQuantity}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>
