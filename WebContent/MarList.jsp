<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>MAR List</title>
</head>

<body>
    <h1>MAR List</h1>

    <table border="1">
        <tr>
            <td>MAR Number</td>
            <td>Date</td>
            <td>Facility Name</td>
        </tr>

        <c:forEach items="${MARS}" var="item">
            <tr>
                <td>
                    <c:out value="${item.marID}" />
                </td>
                <td>
                    <c:out value="${item.date}" />
                </td>
                <td>
                    <c:out value="${item.facilityName}" />
                </td>
                <td>
                    <a href="/mac_repair/MarController?action=ListSpecificMarAction&username=${item.marID}">View</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <ul>
        <li><a href="UserHome.jsp">User Home</a></li>
    </ul>
</body>

</html>