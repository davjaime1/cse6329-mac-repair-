<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Company Management</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="main">
  <div class="header">
    <div class="header_resize">

<!-- TO MAKE THE URL REFERENCES WORK YOU MUST HAVE SESSION ID DISABLED IN URL - SEE WEB.XML -->
	  <div style="float:right">
	  <form align="right" name="form1" method="post" action="index.jsp">
  	  <label>
  	  <input name="submit2" type="submit" id="submit2" value="Logout">
  	  </label>
	  </form>
	  </div>
	
      <div class="logo"><h1><a href="<c:url value='/' />">Mac Repair</a></h1></div>
  <div class="content">  

      <div class="menu_nav">
        <ul>
          <li><a href="RequestReservation.jsp"  target="_top"><span>Request Reservation</span></a></li>
          <li><a href="/mac_repair/RepairerViewAssignedController?action=listReservedRepairers" target="_top"><span>View My Reserved Repairs</span></a></li>
          <li><a href="ViewProfile.jsp"  target="_top"><span>View My Profile</span></a></li>
        </ul>
      </div>
    </div>
  </div>
  </div>
  </div>  
</body>
</html>