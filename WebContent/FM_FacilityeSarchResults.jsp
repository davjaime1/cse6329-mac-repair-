<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Facility List</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<body>
    <div class="header_resize">
      <div class="logo"><h1><a href="/mac_repair">MAC Management Application</a></h1></div>
      
  </div>


     
      
  <form action="/mac_repair/FM_FacilityController?action=listSpecificCompany" method="post">          
       <table border="1" class="myTable"> 
			<tr class="myTableRow"> 
				<th class="myTableHead" style="padding-right: 35px; text-align: left">Facility Name</th> 
				<th class="myTableHead" style="padding-right: 20px; text-align: left">Facility Type</th>
				<th class="myTableHead" style="padding-right: 30px; text-align: left">Time Interval</th> 
                <th class="myTableHead" style="padding-right: 30px; text-align: left">Duration</th> 
                <th class="myTableHead" style="padding-right: 30px; text-align: left">Venue</th> 
			</tr>

 		<c:forEach items="${FACILITIES}" var="item" varStatus="status">
			<tr class="myTableRow">
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.facilityName}" /></td>
			<td class="myTableCell" style="padding-right: 35px; "><c:out value="${item.facilityType}" /></td>
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.timeInterval}" /></td>
			<td class="myTableCell" style="padding-right: 30px; "><c:out value="${item.duration}" /></td>
            <td class="myTableCell" style="padding-right: 30px; "><c:out value="${item.venue}" /></td>
			</tr>
		</c:forEach>
 </table>
 </form>
</body>
</html>