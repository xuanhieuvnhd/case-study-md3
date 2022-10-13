<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User</title>
    <c:import url="head.jsp"/>
    <style>
        .message{
            color: #1250ff;
        }
    </style>
</head>
<body>
<c:import url="header.jsp"/>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<a href="${pageContext.request.contextPath}/users?action=display">Back To Manager User</a>
<main class="my-form">
    <div class="cotainer">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header">Edit User</div>
                    <div class="card-body">
                        <form name="my-form" onsubmit="return validform()" action="users?action=edit" method="post">
                            <div class="form-group row">
                                <label for="user_name" class="col-md-4 col-form-label text-md-right">User Name</label>
                                <div class="col-md-6">
                                    <input type="text" class="form-control" id="user_name" value="<c:out value='${user.userName}' />" name="userName" required>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="full_name" class="col-md-4 col-form-label text-md-right">Password</label>
                                <div class="col-md-6">
                                    <input type="password" class="form-control" id="full_name" name="password" value="<c:out value='${user.password}'/>" >
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="email_address" class="col-md-4 col-form-label text-md-right">E-Mail</label>
                                <div class="col-md-6">
                                    <input type="email" class="form-control" id="email_address" name="email" value="<c:out value='${user.email}'/>" />
                                </div>
                            </div>



                            <div class="form-group row">
                                <label for="phone_number" class="col-md-4 col-form-label text-md-right">Phone Number</label>
                                <div class="col-md-6">
                                    <input type="text" id="phone_number" class="form-control" name="phoneNumber" value="<c:out value='${user.phoneNumber}'/>" >
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="present_address" class="col-md-4 col-form-label text-md-right">Address</label>
                                <div class="col-md-6">
                                    <input type="text" id="present_address" class="form-control" name="address" value="<c:out value='${user.address}'/>" >
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="present_address" class="col-md-4 col-form-label text-md-right">Role</label>
                                <div class="col-md-6">
                                    <input type="text" id="present_role" class="form-control" name="role" value="<c:out value='${user.role}'/>" >
                                </div>
                            </div>

                            <div class="col-md-6 offset-md-4">
                                <button type="submit" class="btn btn-primary">
                                    Edit
                                </button>
                            </div>
                        </form>

                    </div>
                </div>
            </div>
        </div>
    </div>

</main>

<c:import url="footer.jsp"/>
</body>
</html>
