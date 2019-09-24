<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>User List</title>
</head>

<body>

    <h1>User List</h1>

    <table border="1">
        <tr>
            <td>Username</td>
            <td>ID</td>
            <td>First Name</td>
            <td>Last Name</td>
            <td>Role</td>
        </tr>

        <c:forEach items="${USERS}" var="user">
            <tr>
                <td>
                    <c:out value="${user.username}" />
                </td>
                <td>
                    <c:out value="${user.id}" />
                </td>
                <td>
                    <c:out value="${user.firstname}" />
                </td>
                <td>
                    <c:out value="${user.lastname}" />
                </td>
                <td>
                    <c:out value="${user.role}" />
                </td>
                <td>
                    <a href="/mac_repair/AdminSpecificUserController?action=ListSpecificUserAction&username=${user.username}">View</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <ul>
        <li><a href="AdminHome.jsp">Admin Home</a></li>
    </ul>

</body>

</html>