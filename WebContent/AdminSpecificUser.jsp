<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <title>Admin > ${ad_user_username}'s Profile</title>
</head>

<body>

    <header>
        <h1>Admin > ${ad_user_username}'s Profile</h1>
    </header>

    <form action="/mac_repair/AdminSpecificUserController?action=ApplyNewValuesAction" method="post">
        <table border="1">
            <tr>
                <td></td>
                <td>Current Values</td>
                <td>New Values</td>
            </tr>

            <tr>
                <td>Username</td>
                <td>${ad_user_username}</td>
            </tr>
            <tr>
                <td>ID</td>
                <td>${ad_user_id}</td>
                <td><input type="text" name="idTextBox" /></td>
            </tr>
            <tr>
                <td>First Name</td>
                <td>${ad_user_firstname}</td>
                <td><input type="text" name="firstnameTextBox" maxlength="45"/></td>
            </tr>
            <tr>
                <td>Last Name</td>
                <td>${ad_user_lastname}</td>
                <td><input type="text" name="lastnameTextBox" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td>${ad_user_password}</td>
                <td><input type="text" name="password" /></td>
            </tr>
            <tr>
                <td>Role</td>
                <td>${ad_user_role}</td>
                <td>
                    <select name="roleDropDown">
                        <option value="default">-- Select a Role --</option>
                        <c:forEach items="${ROLES}" var="role">
                            <option value="${role.id}">${role.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Address</td>
                <td>${ad_user_address}</td>
                <td><input type="text" name="address" /></td>
            </tr>
            <tr>
                <td>City</td>
                <td>${ad_user_city}</td>
                <td><input type="text" name="city" /></td>
            </tr>
            <tr>
                <td>State</td>
                <td>${ad_user_state}</td>
                <td>
                    <select name="stateDropDown">
                        <option value="default">-- Select a State --</option>
                        <c:forEach items="${STATES}" var="state">
                            <option value="${state.id}">${state.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Zip</td>
                <td>${ad_user_zip}</td>
                <td><input type="text" name="zip" /></td>
            </tr>
            <tr>
                <td>Phone</td>
                <td>${ad_user_phone}</td>
                <td><input type="text" name="phone" /></td>
            </tr>
            <tr>
                <td>Email</td>
                <td>${ad_user_email}</td>
                <td><input type="text" name="email" /></td>
            </tr>
        </table>
        <input type="submit" value="Apply Changes">
        <font color="red">${ERR_MSG}</font>

        <ul>
            <li><a href="AdminHome.jsp">Admin Home</a></li>
        </ul>
    </form>
</body>

</html>