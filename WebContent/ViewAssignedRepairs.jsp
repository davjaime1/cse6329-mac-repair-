<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Companies List</title>
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
      <div class="logo"><h1><a href="<c:url value='/mac_repair' />">Mac Repair</a></h1></div>
      <div class="menu_nav">
      </div>
  </div>
     <div class="mainbar"><div class="submb"></div></div>
      
 <form action="/mac_repair/RepairerViewAssignedController?action=listAssignedRepair" method="post">          
       <table border="1" class="myTable"> 
			<tr class="myTableRow"> 
				<th class="myTableHead" style="padding-right: 35px; text-align: left">Mar Number</th>  				
				<th class="myTableHead" style="padding-right: 35px; text-align: left">Facility Name</th> 
				<th class="myTableHead" style="padding-right: 20px; text-align: left">Facility Type</th>
				<th class="myTableHead" style="padding-right: 20px; text-align: left">Urgency</th>
				<th class="myTableHead" style="padding-right: 20px; text-align: left">Description</th>
				<th class="myTableHead" style="padding-right: 20px; text-align: left">Reported Date</th>
				<th class="myTableHead" style="padding-right: 20px; text-align: left">Reported By</th>
				<th class="myTableHead" style="padding-right: 20px; text-align: left">Assigned Date</th>
				<th class="myTableHead" style="padding-right: 20px; text-align: left">Estimate of Repair</th>
				
			</tr>

 		<c:forEach items="${REPAIRERS}" var="item" varStatus="status">
			<tr class="myTableRow">
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.assignedmar}" /></td>
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.facilityname}" /></td>
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.facilitytype}" /></td>
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.urgency}" /></td>
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.description}" /></td>
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.reporteddate}" /></td>
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.reportedby}" /></td>
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.assignedDate}" /></td>
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.estimateofrepair}" /></td>


			
            <td> <a href="/mac_repair/RepairerViewAssignedController?action=listSpecificAssignedRepairs&id=${item.assignedmar}">View</a></td>
			</tr>
		</c:forEach>
 </table>
 </form>
 <li><a href="Repairer_Home.jsp"  target="_top"><span>Repairer Homepage</span></a></li>  
</body>
</html>