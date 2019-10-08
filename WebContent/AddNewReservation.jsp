<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Create Reservation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<body>
<div style="float:right">
	  <form align="right" name="form1" method="post" action="index.jsp">
  	  <label>
  	  <input name="submit2" type="submit" id="submit2" value="Logout">
  	  </label>
	  </form>
	  </div>
    <div class="header_resize">
      <div class="logo"><h1><a href="<c:url value='/Repairer_Home.jsp' />">Mac Repair</a></h1></div>
      <div class="menu_nav">
      </div>
  </div>
     <div class="mainbar"><div class="submb"></div></div>
     
<table>
  <tr>
   <td>
         <table border="1" class="myTable"> 

    <tr>
    <td> Facility Name: </td>
    <td> <c:out value="${RESERVATION.facilityname}" /> </td>
    </tr>

    <tr>
    <td> Facility Type: </td>
    <td> <c:out value="${RESERVATION.facilitytype}" /> </td>
    </tr>
    
    <tr>
    <td> Venue: </td>
    <td> <c:out value="${RESERVATION.venue}" /> </td>
    </tr>
    
    <tr>
    <td> Date: </td>
    <td> <c:out value="${RESERVATION.date}" /> </td>
    </tr>
    
    <tr>
    <td> From: </td>
    <td> <c:out value="${RESERVATION.from}" /> </td>
    </tr>
    
    <tr>
    <td> To: </td>
    <td> <c:out value="${RESERVATION.to}"/> </td>
    </tr>

    <tr>
    </tr>
    </table>
</td>
</tr>
</table>
      
 <li><a href="Repairer_Home.jsp"  target="_top"><span>Repairer Homepage</span></a></li>  
</body>
</html>