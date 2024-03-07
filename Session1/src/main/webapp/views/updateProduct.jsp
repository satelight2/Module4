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
    <title>Sửa sản phẩm</title>
</head>
<body>
<form action="" method="post">
    <table>
        <tr>
            <td>Mã sản phẩm</td>
            <td><input type="text" name="productID"  value="${updateProduct.productId}" readonly></td>
        </tr>
        <tr>
            <td>Tên sản phẩm</td>
            <td><input type="text" name="productName" value="${updateProduct.productName}"></td>
        </tr>
        <tr>
            <td>Manufacture</td>
            <td><input type="text" name="manufacturer" value="${updateProduct.manufacturer}" ></td>
        </tr>
        <tr>
            <td>Ngày tạo</td>
            <td><input type="date" name="created" ></td>
        </tr>
        <tr>
            <td>Batch</td>
            <td><input type="number" name="batch" value="${updateProduct.batch}" ></td>
        </tr>
        <tr>
            <td>Số lượng</td>
            <td><input type="number" name="quantity" value="${updateProduct.quantity}" ></td>
        </tr>
        <tr>
            <td>Trạng thái</td>
            <td><input type="checkbox" name="productStatus"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Update" name="action"></td>
        </tr>
    </table>
</form>
</body>
</html>
