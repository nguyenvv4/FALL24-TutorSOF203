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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<form action="/user/add" method="post">
    <label>id</label>
    <input type="text" name="id"> <br>
    <label>name</label>
    <input type="text" name="name"> <br>
    <label>address</label>
    <input type="text" name="address"> <br>
    <label>age</label>
    <input type="text" name="age"> <br>
    <label>status</label>
    <input type="radio" name="status" value="Doc than"> Doc than
    <input type="radio" name="status" value="Co nguoi iu"> Co nguoi iu <br>
    <button type="submit" class="btn btn-success" onclick="return confirm('Ban co muon them khong ?')">Add</button>
</form>

<div>${listUser.size() <=0 ? 'Khong co phan tu nao':''}</div>
<table class="table">
    <thead>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>addree</td>
        <td>age</td>
        <td>status</td>
        <td>Action</td>
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
            <td><a href="/user/detail?id=${user.id}" class="btn btn-success">Detail</a>
                <a href="/user/delete?id=${user.id}" class="btn btn-success"
                   onclick="return confirm('Ban co muon xoa khong ?')">Delete</a></td>

        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
