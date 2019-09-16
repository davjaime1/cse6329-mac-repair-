<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Search Users</title>
</head>

<body>

    <h1>Search Users</h1>

    <form action="/mac_repair/AdminController?action=FilterUsersAction" method="post">
        <table border="1">
            <tr>

                <td>Filter by Role</td>
                <td>
                    <select name="roleDropDown">
                        <option value="default">-- Select a Role --</option>
                        <c:forEach items="${ROLES}" var="role">
                            <option value="${role.id}">${role.name}</option>
                        </c:forEach>
                    </select>
                </td>


            </tr>
        </table>
        <input type="submit" value="Submit">
        <font color="red">${ERR_MSG}</font>
    </form>

    <ul>
        <li><a href="AdminHome.jsp">Admin Home</a></li>
    </ul>

</body>

</html>