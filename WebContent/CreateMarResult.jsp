<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Create MAR Result</title>
</head>

<body>

    <h1>Submitted MAR</h1>

    <p>
        TODO: Fill in with MAR to display result to user <br>
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
        <li><a href="UserHome.jsp">User Home</a></li>
    </p>
</body>

</html>