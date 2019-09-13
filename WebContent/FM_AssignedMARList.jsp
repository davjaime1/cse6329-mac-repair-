<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>MAR List</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<body>
    <div class="header_resize">
      <div class="logo"><h1><a href="/mac_repair">List of MAR</a></h1></div>
      <div class="menu_nav">
      </div>
  </div>

<input name="errMsg"  value="<c:out value='${errorMsgs}'/>" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
     <div class="mainbar"><div class="submb"></div></div>
      
 <form action="/mac_repair/FM_AssignMARController?action=listSpecificCompany" method="post">          
       <table border="1" class="myTable"> 
			<tr class="myTableRow"> 
				<th class="myTableHead" style="padding-right: 20px; text-align: left">MAR Number</th>
				<th class="myTableHead" style="padding-right: 35px; text-align: left">Facility Name</th> 
				<th class="myTableHead" style="padding-right: 20px; text-align: left">Facility Type</th>
				<th class="myTableHead" style="padding-right: 30px; text-align: left">Urgency</th> 
                <th class="myTableHead" style="padding-right: 30px; text-align: left">Description</th> 
                <th class="myTableHead" style="padding-right: 30px; text-align: left">Reported Date</th> 
                <th class="myTableHead" style="padding-right: 30px; text-align: left">Reported By</th> 
                <th class="myTableHead" style="padding-right: 30px; text-align: left">Assigned To</th> 
                <th class="myTableHead" style="padding-right: 30px; text-align: left">Assigned Date</th> 
                <th class="myTableHead" style="padding-right: 30px; text-align: left">Estimate Repair Time</th> 
			</tr>

 		<c:forEach items="${ASSIGNEDMARS}" var="item" varStatus="status">
			<tr class="myTableRow">
			<td class="myTableCell" style="padding-right: 20px; "><a href="/mac_repair/FM_AssignMARController?action=listSpecificAssignedMAR&id=${item.marID}"><c:out value="${item.marID}" /></a></td>
			<td class="myTableCell" style="padding-right: 35px; "><c:out value="${item.facilityName}" /></td>
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.facilityType}" /></td>
			<td class="myTableCell" style="padding-right: 30px; "><c:out value="${item.urgency}" /></td>
            <td class="myTableCell" style="padding-right: 30px; "><c:out value="${item.description}" /></td>
            <td class="myTableCell" style="padding-right: 30px; "><c:out value="${item.date}" /></td>
            <td class="myTableCell" style="padding-right: 30px; "><c:out value="${item.reportedUser}" /></td>
            <td class="myTableCell" style="padding-right: 30px; "><c:out value="${item.assignedTo}" /></td>
            <td class="myTableCell" style="padding-right: 30px; "><c:out value="${item.assignedDate}" /></td>
            <td class="myTableCell" style="padding-right: 30px; "><c:out value="${item.estimateOfRepair}" /></td>
			</tr>
		</c:forEach>
 </table>
 </form>
</body>
</html>