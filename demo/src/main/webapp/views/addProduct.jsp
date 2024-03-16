<%--
  Created by IntelliJ IDEA.
  User: ngoduy2
  Date: 07/03/2024
  Time: 7:29 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm sản phẩm</title>
</head>
<body>

<h1>Thêm sản phẩm</h1>
<form action="/products" method="post">
    <table>
        <tr>
            <td>Mã sản phẩm</td>
            <td><input type="text" name="productID"></td>
        </tr>
        <tr>
            <td>Tên sản phẩm</td>
            <td><input type="text" name="productName"></td>
        </tr>
        <tr>
            <td>Manufacture</td>
            <td><input type="text" name="manufacturer"></td>
        </tr>
        <tr>
            <td>Ngày tạo</td>
            <td><input type="date" name="created"></td>
        </tr>
        <tr>
            <td>Batch/td>
            <td><input type="number" name="batch"></td>
        </tr>
        <tr>
            <td>Số lượng</td>
            <td><input type="number" name="quantity"></td>
        </tr>
        <tr>
            <td>Trạng thái</td>
            <td><input type="checkbox" name="productStatus"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Create" name="action"></td>
        </tr>
    </table>
</form>
</body>
</html>
