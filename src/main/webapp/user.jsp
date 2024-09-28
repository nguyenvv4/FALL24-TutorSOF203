<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 28/09/2024
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<h2>Ho ten la: ${hoTen}</h2>--%>
<%--<h2>Thong tin user la</h2>--%>
<%--<h3>id : ${user.id}</h3>--%>
<%--<h3>name : ${user.name}</h3>--%>
<%--<h3>address : ${user.address}</h3>--%>
<%--Cach 2--%>
<%--<h3>id : ${user.getId()}</h3>--%>

<table>
    <thead>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>addree</td>
        <td>age</td>
        <td>status</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${listUser}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.address}</td>
            <td>${user.age}</td>
            <td>${user.status}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
