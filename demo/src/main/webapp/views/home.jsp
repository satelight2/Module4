<%--
  Created by IntelliJ IDEA.
  User: ngoduy2
  Date: 07/03/2024
  Time: 10:25 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Trang chu</title>
</head>
<body>
<h1>${email}</h1>
<h1>Giới tính : 
    <c:if test="${gender == true}">
        <span>Nam</span> </c:if>
    <c:if test="${gender == false}">
        <span>Nữ</span></c:if>
</h1>
<h1>Sở thích
<ul>
    <c:forEach var="hobbies" items="${list}">
        <li>${hobbies}</li>
    </c:forEach>
</ul>
</h1>
</body>
</html>
