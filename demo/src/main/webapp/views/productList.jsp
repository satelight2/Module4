<%--
  Created by IntelliJ IDEA.
  User: ngoduy2
  Date: 07/03/2024
  Time: 3:57 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Danh sách sản phẩm</title>
</head>
<body>

    <form action="/products" method="get">
        <input type="text" name="productName" placeholder="Nhập tên sản phẩm">
        <input type="submit" value="Search" name="action">
    </form>
    <table border="1">
        <tr>
            <th>Mã sản phẩm</th>
            <th>Tên sản phẩm</th>
            <th>Manufacture</th>
            <th>Ngày tạo</th>
            <th>Batch</th>
            <th>Số lượng</th>
            <th>Trạng thái</th>
            <th>Thao tác</th>
        </tr>
        <c:forEach items="${listClone}" var="product">
            <tr>
                <td>${product.productId}</td>
                <td>${product.productName}</td>
                <td>${product.manufacturer}</td>
                <td>${product.created}</td>
                <td>${product.batch}</td>
                <td>${product.quantity}</td>
                <td>${product.productStatus}</td>
                <td>
                    <a href="/products?productId=${product.productId}&&action=UpdateGet">Sửa</a>
                    <a href="/products?productId=${product.productId}&&action=Delete">Xóa</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="views/addProduct.jsp">Thêm sản phẩm</a>
</body>
</html>
