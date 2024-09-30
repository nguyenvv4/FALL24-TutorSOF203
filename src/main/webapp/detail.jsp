<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 30/09/2024
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>

<form action="/user/update" method="post">
    <label>id</label>
    <input type="text" name="id" value="${userDetail.id}" readonly> <br>
    <label>name</label>
    <input type="text" name="name" value="${userDetail.name}"> <br>
    <label>address</label>
    <input type="text" name="address" value="${userDetail.address}"> <br>
    <label>age</label>
    <input type="text" name="age" value="${userDetail.age}"> <br>
    <label>status</label>
    <input type="radio" name="status" value="Doc than" ${userDetail.status == "Doc than" ? 'checked':''}> Doc than
    <input type="radio" name="status" value="Co nguoi iu" ${userDetail.status == "Co nguoi iu" ? 'checked':''}> Co nguoi
    iu <br>
    <button type="submit" class="btn btn-success" onclick="return confirm('Ban co muon sua khong ?')">Add</button>
</form>

</body>
</html>
