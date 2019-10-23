<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
		var $datepicker = $('#datepicker');
	    $datepicker.datepicker();
	    $datepicker.datepicker('setDate', new Date());
  } );
  </script>
<title>Facility List</title>
<h1><a href="/mac_repair/FM_MARController?action=homepage"  target="_top"> Home Page </a></h1> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<body>

<input name="errMsg"  value="<c:out value='${errorMsgs.errorMsg}'/>" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
<table>
<tr>
	<td>
	<form action="/mac_repair/FM_FacilityController?action=searchFacility" method="post">
	<table style="width: 1200px; ">
	<tr>
	<tr>
    <td> Facility Type (*): </td>
    <td> 
    <select name="idfacilitytype">
          <c:forEach items="${FACILITYTYPE}" var="item" varStatus="status">
            <option value="${item.id}">${item.value}</option>
          </c:forEach>
    </select>
    </td>
    </tr>
 
    <tr>
    <td> Date (*): </td>
    <td> 
   <input type="text" name ="iddateTimePicker" id="datepicker">
    </td>   
   
    </tr>

</table>
  <input type="submit" value="Submit">
	</form>      
</td>
</tr>
</table>
</body>
</html>