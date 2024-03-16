<%--
  Created by IntelliJ IDEA.
  User: ngoduy2
  Date: 08/03/2024
  Time: 8:08 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tìm kiếm sản phẩm</title>
</head>
<body>
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
                <a href="/products?productId=${product.productId}&&action=Update">Sửa</a>
                <a href="/products?productId=${product.productId}&&action=Delete">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="views/addProduct.jsp">Thêm sản phẩm</a>
</body>
</html>
