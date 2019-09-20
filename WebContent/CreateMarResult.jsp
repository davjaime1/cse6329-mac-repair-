<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Submitted MAR</title>
</head>

<body>

    <h1>Submitted MAR</h1>

    <table border="1">
        <tr>
            <td>Facility Type</td>
            <td>${cmr_facilitytype}</td>
        </tr>
        <tr>
            <td>Facility Name</td>
            <td>${cmr_facilityname}</td>
        </tr>
        <tr>
            <td>Urgency</td>
            <td>${cmr_urgency}</td>
        </tr>
        <tr>
            <td>Reported By</td>
            <td>${cmr_reportedby}</td>
        </tr>
        <tr>
            <td>Date</td>
            <td>${cmr_date}</td>
        </tr>
        <tr>
            <td>MAR Number</td>
            <td>${cmr_marnumber}</td>
        </tr>
        <tr>
            <td>Description</td>
            <td>${cmr_description}</td>
        </tr>
    </table>

    <ul>
        <li><a href="/mac_repair/UserController?action=ToHomePage">Back to Home</a></li>
    </ul>
</body>

</html>