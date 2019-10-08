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
    <p>
        <h1>MAR List</h1>
    </p>

    <p>
        <!-- Search box -->
        <h2>Filter By</h2>
        <form action="/mac_repair/MarController?action=ApplyMarFilterAction" method="post">
            <table border="1">
                <tr>
                    <td>Facility Name</td>
                    <td>
                        <select name="facilityNameDropDown">
                            <option value="default">-- Select a Facility Name</option>
                            <c:forEach items="${FACILITIES}" var="facility">
                                <option value="${facility.name}">${facility.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>
                        <input type="submit" value="Submit">
                    </td>
                    <td>
                        <font color="red">${ERR_MSG}</font>
                    </td>
                </tr>
            </table>
        </form>
    </p>

    <p>
        <!-- Start of MAR table -->
        <h2>Result</h2>
        <table border="1">
            <tr>
                <td>MAR Number</td>
                <td>Date</td>
                <td>Facility Name</td>
                <td>Urgency</td>
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
                        <c:out value="${item.urgency}" />
                    </td>
                    <td>
                        <a href="/mac_repair/MarController?action=ViewSpecificMar&marid=${item.marID}">View</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </p>

    <p>
        <ul>
            <li><a href="UserHome.jsp">User Home</a></li>
        </ul>
    </p>
</body>

</html>