<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Specific Assigned MAR</title>
</head>
    <div class="header_resize">
      <div class="logo"><h1><a href="/mac_repair">MAC Repair Application</a></h1></div>
      <div class="menu_nav">
      </div>
  </div>
<body>
<table>
  <tr>
   <td>
         <table border="1" class="myTable"> 
    <tr>
    <td> MAR ID: </td>
    <td> <c:out value="${ASSIGNEDMARS.marID}" /> </td>
    </tr>

    <tr>
    <td> Facility Name: </td>
    <td> <c:out value="${ASSIGNEDMARS.facilityName}"/> </td>
    </tr>

    <tr>
    <td> Facility Type: </td>
    <td> <c:out value="${ASSIGNEDMARS.facilityType}" /> </td>
    </tr>

    <tr>
    <td> Urgency: </td>
    <td> <c:out value="${ASSIGNEDMARS.urgency}" /> </td>
    </tr>
   <tr>
    <td> Description: </td>
    <td> <c:out value="${ASSIGNEDMARS.description}" /> </td>
    </tr>
       <tr>
    <td> Reported User: </td>
    <td> <c:out value="${ASSIGNEDMARS.reportedUser}" /> </td>
    </tr>
       <tr>
    <td> Reported Date: </td>
    <td> <c:out value="${ASSIGNEDMARS.date}" /> </td>
    </tr>
           <tr>
    <td> Assigned To: </td>
    <td> <c:out value="${ASSIGNEDMARS.assignedTo}" /> </td>
    </tr>
           <tr>
    <td> Assigned Date: </td>
    <td> <c:out value="${ASSIGNEDMARS.assignedDate}" /> </td>
    </tr>
           <tr>
    <td> Estimate Repair Time: </td>
    <td> <c:out value="${ASSIGNEDMARS.estimateOfRepair}" /> </td>
    </tr>

    </table>
</td>
</tr>
</table>
<button onclick="window.location.href = '/mac_repair/FM_AssignMARController?action=modify&id=${MAR.marID}';" class="btn default">Modify MAR</button>

</body>
</html>