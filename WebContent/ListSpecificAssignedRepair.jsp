<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Specific Assigned Repair</title>
</head>
<div style="float:right">
	  <form align="right" name="form1" method="post" action="index.jsp">
  	  <label>
  	  <input name="submit2" type="submit" id="submit2" value="Logout">
  	  </label>
	  </form>
	  </div>
    <div class="header_resize">
      <div class="logo"><h1><a href="/mac_repair/Repairer_Home.jsp">Mac Repair</a></h1></div>
      <div class="menu_nav">
      </div>
  </div>
<body>
<table>
  <tr>
   <td>
         <table border="1" class="myTable"> 
    <tr>
    <td> Mar Number: </td>
    <td> <c:out value="${REPAIRERS.assignedmar}" /> </td>
    </tr>

    <tr>
    <td> Facility Name: </td>
    <td> <c:out value="${REPAIRERS.facilityname}" /> </td>
    </tr>

    <tr>
    <td> Facility Type: </td>
    <td> <c:out value="${REPAIRERS.facilitytype}" /> </td>
    </tr>
    
    <tr>
    <td> Urgency: </td>
    <td> <c:out value="${REPAIRERS.urgency}" /> </td>
    </tr>
    
    <tr>
    <td> Description: </td>
    <td> <c:out value="${REPAIRERS.description}" /> </td>
    </tr>
    
    <tr>
    <td> Reported Date: </td>
    <td> <c:out value="${REPAIRERS.reporteddate}"/> </td>
    </tr>
    
    <tr>
    <td> Reported By: </td>
    <td> <c:out value="${REPAIRERS.reportedby}"/> </td>
    </tr>
    
    <tr>
    <td> Assigned Date: </td>
    <td> <c:out value="${REPAIRERS.assignedDate}"/> </td>
    </tr>
    
    <tr>
    <td> Estimate of Repair: </td>
    <td> <c:out value="${REPAIRERS.estimateofrepair}"/> </td>
    </tr>

    <tr>
    </tr>
    </table>
</td>
</tr>
</table>

    <form name="Make Reservation" action="/mac_repair/RepairerReservationsController?action=searchFreeFacilities&id=${REPAIRERS.facilityname}&date=${REPAIRERS.assignedDate}" method="post">
    <input name="action" value="searchFreeFacilities" type="hidden">
    <input type="submit" value="Make Reservation">
    </form>
</body>
</html>