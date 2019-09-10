<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Company form</title>

</head>
<body>

	<div style="float:right">
	<form align="right" name="form1" method="post" action="index.jsp">
  	<label>
  	<input name="submit2" type="submit" id="submit2" value="Logout">
  	</label>
	</form>
	</div>

	<div class="logo"><h1><a href="<c:url value='/' />">Mac Repair</a></h1></div>
	
    <form name="registerForm" action="/mac_repair/SearchRequestedMarController?login" method="post">
    <table style="width: 400px; ">
    <tr>
    <td>Facility Type : </td>
    <td> <input name="facilityType" value="<c:out value='${mar.facilityType}'/>" type="text" maxlength="16"> </td>
    </tr>

    <tr>
    <td> Facility Name: </td>
    <td> <input name="faclityName" value="<c:out value='${mar.facilityName}'/>" type="text" maxlength="16"> </td>
    </tr>
	
    </table>
    
    <input type="Submit" value="Search">
    </form>
    
    
    <li><a href="RequestedMarSearchResults.jsp"  target="_top"><span>Results Page</span></a></li>   
    <li><a href="FM_Home.jsp"  target="_top"><span>Return to Homepage</span></a></li>  
    
</form>
    
</body>
</html>