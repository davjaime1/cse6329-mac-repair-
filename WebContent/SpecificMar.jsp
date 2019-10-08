<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>MAR #<c:out value="${cmr_marnumber}" /></title>
</head>

<body>

    <h1>MAR Details</h1>

    <table border="1">
        <tr>
            <td>MAR ID</td>
            <td>
                <c:out value="${cmr_marnumber}" />
            </td>
        </tr>
        <tr>
            <td>Date</td>
            <td>
                <c:out value="${cmr_date}" />
            </td>
        </tr>
        <tr>
            <td>Facility Type</td>
            <td>
                <c:out value="${cmr_facilitytype}" />
            </td>
        </tr>
        <tr>
            <td>Facility Name</td>
            <td>
                <c:out value="${cmr_facilityname}" />
            </td>
        </tr>
        <tr>
            <td>Urgency</td>
            <td>
                <c:out value="${cmr_urgency}" />
            </td>
        </tr>
        <tr>
            <td>Reported By</td>
            <td>
                <c:out value="${cmr_reportedby}" />
            </td>
        </tr>
        <tr>
            <td>Description</td>
            <td>
                <c:out value="${cmr_description}" />
            </td>
        </tr>
    </table>

    <ul>
        <li><a href="/mac_repair/UserController?action=ToHomePage">Back to Home</a></li>
    </ul>
</body>

</html>