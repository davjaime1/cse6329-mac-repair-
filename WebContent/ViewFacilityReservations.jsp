<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>View Free Time</title>
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
      <div class="logo"><h1><a href="<c:url value='/FM_Home.jsp' />">Mac Repair</a></h1></div>
      <div class="menu_nav">
      </div>
  </div>
     <div class="mainbar"><div class="submb"></div></div>
     

 <table border="1" class="myTable"> 
			<tr class="myTableRow"> 
				<th class="myTableHead" style="padding-right: 35px; text-align: left">Facility Name</th> 
				<th class="myTableHead" style="padding-right: 20px; text-align: left">Facility Type</th>
				<th class="myTableHead" style="padding-right: 30px; text-align: left">Date</th> 
                <th class="myTableHead" style="padding-right: 30px; text-align: left">Reservation From</th> 
                <th class="myTableHead" style="padding-right: 30px; text-align: left">Reservation To</th> 
                <th class="myTableHead" style="padding-right: 30px; text-align: left">Venue</th> 
			</tr>

 		<c:forEach items="${RESERVATION}" var="item" varStatus="status">
			<tr class="myTableRow">			
			<td class="myTableCell" style="padding-right: 35px; "><c:out value="${item.facilitytype}" /></td>
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.facilityname}" /></td>
			<td class="myTableCell" style="padding-right: 30px; "><c:out value="${item.date}" /></td>
            <td class="myTableCell" style="padding-right: 30px; "><c:out value="${item.from}" /></td>
            <td class="myTableCell" style="padding-right: 30px; "><c:out value="${item.to}" /></td>
            <td class="myTableCell" style="padding-right: 30px; "><c:out value="${item.venue}" /></td>
			</tr>
		</c:forEach>
 </table>
 
      
 <li><a href="FM_Home.jsp"  target="_top"><span>Home page</span></a></li>  
</body>
</html>