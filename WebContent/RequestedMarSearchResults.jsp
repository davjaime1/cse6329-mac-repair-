<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Company form</title>
<style>
.btn {
  border: none;
  background-color: inherit;
  padding: 14px 28px;
  font-size: 16px;
  cursor: pointer;
  display: inline-block;
}

.default:hover {
  background: #e7e7e7;
}
</style>
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

	<button onclick="window.location.href = 'ViewSpecificMar.jsp';" class="btn default">Facility Name: <br /> Facility Type: <br /> Urgency: <br /></button>
	
    <li><a href="ViewSpecificMar.jsp"  target="_top"><span>View Specific MAR Page</span></a></li>
    <li><a href="FM_Home.jsp"  target="_top"><span>Return to Homepage</span></a></li>  
</body>
</html>