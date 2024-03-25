<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Product List</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
  <h1>Product List</h1>
  <table class="table">
    <thead>
    <tr>
      <th>Name</th>
      <th>Description</th>
      <th>Price</th>
      <th>Quantity</th>
      <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${products}" var="product">
      <tr>
        <td>${product.name}</td>
        <td>${product.description}</td>
        <td>${product.price}</td>
        <td>${product.stockQuantity}</td>
        <td>
          <form method="post" action="cart/add/${product.productId}">
            <input type="number" name="quantity" value="1" min="1" max="${product.stockQuantity}">
            <button type="submit" class="btn btn-primary">Add to Cart</button>
          </form>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>
