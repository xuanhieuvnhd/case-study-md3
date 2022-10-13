<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manager User</title>
    <c:import url="head.jsp"/>
</head>
<body>
<c:import url="header.jsp"/>
<a href="/users?action=create">Thêm mới User</a>
<table class="table table-striped w-auto" style="padding: 20px;border: 1px" >

    <!--Table head-->
    <thead>
    <tr>
        <th>User Name</th>
        <th>Password</th>
        <th>Email</th>
        <th>Phone Number</th>
        <th>Address</th>
        <th>Role</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listUser}" var="user">
    <tr class="table-info">
        <td><c:out value="${user.userName}"/></td>
        <td><c:out value="${user.password}"/></td>
        <td><c:out value="${user.email}"/></td>
        <td><c:out value="${user.phoneNumber}"/></td>
        <td><c:out value="${user.address}"/></td>
        <td><c:out value="${user.role}"/></td>
        <td><a href="/users?action=edit&userName=${user.userName}">Edit</a></td>
        <td><a href="/users?action=delete&userName=${user.userName}">Delete</a></td>

    </tr>
    </c:forEach>
    </tbody>
</table>
<c:import url="footer.jsp"/>
</body>
</html>
