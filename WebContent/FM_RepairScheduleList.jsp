<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Repairer Schedule List</title>
<h1><a href="/mac_repair/FM_RepairerScheduleController?action=homepage"  target="_top"> Home Page </a></h1> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<body>      
<table border="1" class="myTable"> 
			<tr class="myTableRow"> 
				<th class="myTableHead" style="padding-right: 20px; text-align: left">Repairer User Name</th>
				<th class="myTableHead" style="padding-right: 35px; text-align: left">Mar Number</th> 
				<th class="myTableHead" style="padding-right: 20px; text-align: left">Schedule Date</th>
			</tr>

 		<c:forEach items="${REPAIRSCHEDULE}" var="item" varStatus="status">
			<tr class="myTableRow">
			<td class="myTableCell" style="padding-right: 35px; "><c:out value="${item.assignedTo}" /></td>
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.marID}" /></td>
			<td class="myTableCell" style="padding-right: 30px; "><c:out value="${item.assignedDate}" /></td>
			</tr>
		</c:forEach>
 </table>

</body>
</html>