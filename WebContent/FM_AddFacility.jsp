<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Facility form</title>
<h1><a href="/mac_repair/FM_FacilityController?action=homepage"  target="_top"> Home Page </a></h1> 
</head>
<body>
<input name="errMsg"  value="<c:out value='${errorMsgs.errorMsg}'/>" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
<table>
  <tr>
   <td>
    <form name="companyForm" action="/mac_repair/FM_FacilityController?saveFacility" method="post">
    <table style="width: 1200px; ">
    <tr>
    <td> Facility Name (*): </td>
    <td> <input name="idfacilityname" value="<c:out value='${facility.facilityName}'/>" type="text" maxlength="16"> </td>
  	<td> <input name="companyIDerror"  value="<c:out value='${errorMsgs.facilityNameError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
    </tr>

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
    <td> Time Interval: </td>
     <td> 
    <select name="idtimeinterval">
          <c:forEach items="${TIMEINTERVAL}" var="item" varStatus="status">
            <option value="${item.id}">${item.value}</option>
          </c:forEach>
    </select>
    </td>
    </tr>

    <tr>
    <td> Duration (*): </td>
    <td> 
    <select name="idduration">
          <c:forEach items="${DURATION}" var="item" varStatus="status">
            <option value="${item.id}">${item.value}</option>
          </c:forEach>
    </select>
    </td>
       </tr>
   <tr>
    <td> Venue (*): </td>
    <td> 
    <select name="idvenue">
          <c:forEach items="${VENUE}" var="item" varStatus="status">
            <option value="${item.id}">${item.value}</option>
          </c:forEach>
    </select>
    </td>   </tr>
    <tr>
    <td colspan="2">(*) Mandatory field</td>
    </tr>
    </table>
    <input name="action" value="saveFacility" type="hidden">
    <input type="submit" value="Insert Facility">
    </form>
</td>
</tr>
</table>


</body>
</html>