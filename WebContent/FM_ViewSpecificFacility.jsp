<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Facility</title>
<h1><a href="/mac_repair/FM_FacilityController?action=homepage"  target="_top"> Home Page </a></h1> 
</head>
<body>

<table>
  <tr>
   <td>
    <table style="width: 1200px; ">
    <tr>
    <td> Facility Name (*): </td>
    <td> <c:out value="${facility.facilityName}" /> </td>
    </tr>

    <tr>
    <td> Facility Type (*): </td>

   <td> <c:out value="${facility.facilityType}" /> </td>
    </tr>

    <tr>
    <td> Time Interval: </td>

   <td> <c:out value="${facility.timeInterval}" /> </td>
 
    </tr>

    <tr>
    <td> Duration (*): </td>
    <td> <c:out value="${facility.duration}" /> </td>
 
       </tr>
   <tr>
    <td> Venue (*): </td>
    <td> <c:out value="${facility.venue}" /> </td>
  </tr>
  
    </table>
  
</td>
</tr>
</table>


</body>
</html>