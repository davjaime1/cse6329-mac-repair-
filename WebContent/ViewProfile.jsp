<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>View Profile</title>
</head>

<body>
    <h1>View Profile</h1>
    <table border="1" class="myTable">
        <tr>
            <td> Username: </td>
            <td>
                <c:out value="${USERS.username}" />
            </td>
        </tr>

        <tr>
            <td> UTA ID: </td>
            <td>
                <c:out value="${USERS.id}" />
            </td>
        </tr>

        <tr>
            <td> First Name: </td>
            <td>
                <c:out value="${USERS.firstname}" />
            </td>
        </tr>

        <tr>
            <td> Last Name: </td>
            <td>
                <c:out value="${USERS.lastname}" />
            </td>
        </tr>

        <tr>
            <td> Password: </td>
            <td>
                <c:out value="${USERS.password}" />
            </td>
        </tr>

        <tr>
            <td> Role: </td>
            <td>
                <c:out value="${USERS.role}" />
            </td>
        </tr>

        <tr>
            <td> Address: </td>
            <td>
                <c:out value="${USERS.address}" />
            </td>
        </tr>

        <tr>
            <td> State: </td>
            <td>
                <c:out value="${USERS.state}" />
            </td>
        </tr>

        <tr>
            <td> City: </td>
            <td>
                <c:out value="${USERS.city}" />
            </td>
        </tr>

        <tr>
            <td> Zip: </td>
            <td>
                <c:out value="${USERS.zip}" />
            </td>
        </tr>

        <tr>
            <td> Phone: </td>
            <td>
                <c:out value="${USERS.phone}" />
            </td>
        </tr>

        <tr>
            <td> Email: </td>
            <td>
                <c:out value="${USERS.email}" />
            </td>
        </tr>
    </table>

    <ul>
        <li><a href="/mac_repair/UserController?action=ToHomePage">Back to Home</a></li>
    </ul>

</body>

</html>