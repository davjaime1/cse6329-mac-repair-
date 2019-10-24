<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <title>Login</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="style.css" rel="stylesheet" type="text/css" />
</head>

<body>

    <h1>Login</h1>

    <form action="/mac_repair/UserController?action=loginUser" method="post">
        <p>
            <table>
                <tr>
                    <td> Username: </td>
                    <td> <input name="idusername" value="<c:out value='${USERS.username}'/>" type="text"> </td>
                </tr>
                <tr>
                    <td> Password: </td>
                    <td> <input name="idpassword" value="<c:out value='${USERS.password}'/>" type="password" /> </td>
                </tr>
            </table>
        </p>

        <p>
            <input type="submit" value="Submit">
            <font color="red">
                <c:out value='${ERR_LOGIN}' />
            </font>
        </p>
    </form>

    <p>
        <ul>
            <li><a href="/mac_repair/UserController?action=registerProfile">Register</a></li>
        </ul>
    </p>

</body>

</html>