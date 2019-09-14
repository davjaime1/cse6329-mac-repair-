<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Company form</title>
</head>
<div style="float:right">
	  <form align="right" name="form1" method="post" action="index.jsp">
  	  <label>
  	  <input name="submit2" type="submit" id="submit2" value="Logout">
  	  </label>
	  </form>
	  </div>
    <div class="header_resize">
      <div class="logo"><h1><a href="/mac_repair">Mac Repair</a></h1></div>
      <div class="menu_nav">
      </div>
  </div>
<body>
<table>
  <tr>
   <td>
         <table border="1" class="myTable"> 
    <tr>
    <td> Date: </td>
    <td> <c:out value="${REPAIRERS.date}" /> </td>
    </tr>

    <tr>
    <td> Mar Num: </td>
    <td> <c:out value="${REPAIRERS.marnum}"/> </td>
    </tr>

    <tr>
    <td> Facility Type: </td>
    <td> <c:out value="${REPAIRERS.facilitytype}" /> </td>
    </tr>

    <tr>
    <td> Facility Name: </td>
    <td> <c:out value="${REPAIRERS.facilityname}" /> </td>
    </tr>
    
    <tr>
    <td> From: </td>
    <td> <c:out value="${REPAIRERS.from}" /> </td>
    </tr>
    
    <tr>
    <td> To: </td>
    <td> <c:out value="${REPAIRERS.to}" /> </td>
    </tr>

    <tr>
    </tr>
    </table>
</td>
</tr>
</table>
<button onclick="window.location.href = 'DeleteMar.jsp';" class="btn default">Cancel Repair</button>
<button onclick="window.location.href = 'AssignMar.jsp';" class="btn default">Modify Repair</button>
</body>
</html>