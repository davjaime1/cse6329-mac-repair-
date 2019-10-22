<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Specific MAR</title>
<h1><a href="/mac_repair/FM_MARController?action=homepage"  target="_top"> Home Page </a></h1> 
</head>
<body>
<table>
  <tr>
   <td>
         <table border="1" class="myTable"> 
    <tr>
    <td> MAR ID: </td>
    <td> <c:out value="${MAR.marID}" /> </td>
    </tr>

    <tr>
    <td> Facility Name: </td>
    <td> <c:out value="${MAR.facilityName}"/> </td>
    </tr>

    <tr>
    <td> Facility Type: </td>
    <td> <c:out value="${MAR.facilityType}" /> </td>
    </tr>

    <tr>
    <td> Urgency: </td>
    <td> <c:out value="${MAR.urgency}" /> </td>
    </tr>
   <tr>
    <td> Description: </td>
    <td> <c:out value="${MAR.description}" /> </td>
    </tr>
       <tr>
    <td> Reported User: </td>
    <td> <c:out value="${MAR.reportedUser}" /> </td>
    </tr>
       <tr>
    <td> Reported Date: </td>
    <td> <c:out value="${MAR.date}" /> </td>
    </tr>

    </table>
</td>
</tr>
</table>
<button onclick="window.location.href = '/mac_repair/FM_MARController?action=assignmar&id=${MAR.marID}';" class="btn default">Assign MAR</button>
</body>
</html>