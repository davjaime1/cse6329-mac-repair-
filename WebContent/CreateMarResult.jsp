<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Submitted MAR</title>
</head>

<body>

    <h1>Submitted MAR</h1>

    <p>
        Facility Type: ${cmr_facilitytype} <br>
        Facility Name: ${cmr_facilityname} <br>
        Urgency: ${cmr_urgency} <br>
        Reported By: ${cmr_reportedby} <br>
        Date: ${cmr_date} <br>
        MAR Number: ${cmr_marnumber} <br>
    </p>

    <p>
        Description: ${cmr_description}
    </p>

    <p>
        <ul>
            <li><a href="UserHome.jsp">View Profile</a></li>
        </ul>
    </p>
</body>

</html>