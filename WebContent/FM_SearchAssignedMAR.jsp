<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Assigned MAR List</title>
<h1><a href="/mac_repair/FM_AssignMARController?action=homepage"  target="_top"> Home Page </a></h1> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<body>

<input name="errMsg"  value="<c:out value='${errorMsgs.errorMsg}'/>" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
<table>
<tr>
	<td>
	<form action="/mac_repair/FM_AssignMARController?action=searchAssignedMAR" method="post">
	<table style="width: 1200px; ">
	<tr>
	<tr>
  	<td> MAR Number: </td>
 	<td> <input name="idmarnumber" value="<c:out value='${assignedmar.marID}'/>" type="text" maxlength="45">  </td>
  	<td> <input name="marnumberError"  value="<c:out value='${errorMsgs.marNumberError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
	</tr>
 
    <tr>
    <td> Facility Name: </td>
    <td> <input name="idfacilityname" value="<c:out value='${assignedmar.facilityName}'/>" type="text" maxlength="16"> </td>
 
    </tr>

</table>
  <input type="submit" value="Submit">
	</form>      
</td>
</tr>
</table>
</body>
</html>