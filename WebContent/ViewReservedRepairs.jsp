<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Reserved Repairs</title>
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
      
 <form action="/mac_repair/RepairerViewReservedController?action=listReservedRepair" method="post">          
       <table border="1" class="myTable"> 
			<tr class="myTableRow"> 
				<th class="myTableHead" style="padding-right: 35px; text-align: left">Date</th> 
				<th class="myTableHead" style="padding-right: 35px; text-align: left">Mar Number</th>  				
				<th class="myTableHead" style="padding-right: 35px; text-align: left">Facility Type</th> 
				<th class="myTableHead" style="padding-right: 20px; text-align: left">Facility Name</th>
				<th class="myTableHead" style="padding-right: 20px; text-align: left">From</th>
				<th class="myTableHead" style="padding-right: 20px; text-align: left">To</th>
			</tr>

 		<c:forEach items="${REPAIRERS}" var="item" varStatus="status">
			<tr class="myTableRow">
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.date}" /></td>
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.marnum}" /></td>			
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.facilitytype}" /></td>
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.facilityname}" /></td>
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.from}" /></td>
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.to}" /></td>
            <td> <a href="/mac_repair/RepairerViewReservedController?action=listSpecificResesrvedRepairs&id=${item.marnum}">View</a></td>
			</tr>
		</c:forEach>
 </table>
 </form>
 <li><a href="Repairer_Home.jsp"  target="_top"><span>Repairer Homepage</span></a></li>  
</body>
</html>