<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 08/10/2024
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Day la trang sinh vien</h1>
<select name="" id="">
    <c:forEach items="${listLopHoc}" var="lopHoc">
        <option value="${lopHoc.id}">${lopHoc.className}</option>
    </c:forEach>

</select>
<table>
    <thead>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>address</td>
        <td>age</td>
        <td>status</td>
        <td>lop</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listSinhVien}" var="sinhVien">
        <tr>
            <td>${sinhVien.id}</td>
            <td>${sinhVien.name}</td>
            <td>${sinhVien.address}</td>
            <td>${sinhVien.age}</td>
            <td>${sinhVien.status}</td>
            <td>${sinhVien.lopHoc}</td>
            <td>
                    <%--                <a href="/sinh-vien/detail?id=${sinhVien}"></a>--%>
                <a href="/sinh-vien/delete?id=${sinhVien.id}"
                   onclick="return confirm('Ban co muon xoa khong')"
                >Delete</a>
            </td>
        </tr>

    </c:forEach>
    </tbody>
</table>
</body>
</html>
