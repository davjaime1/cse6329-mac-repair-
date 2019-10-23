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
<title>Assign MAR</title>
<h1><a href="/mac_repair/FM_AssignMARController?action=homepage"  target="_top"> Home Page </a></h1> 
</head>
<body>
<input name="errMsg"  value="<c:out value='${errorMsgs.errorMsg}'/>" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
<table>
  <tr>
   <td>
    <form name="companyForm" action="/mac_repair/FM_AssignMARController?saveassignedmar&marid=${MAR.marID}&ftype=${MAR.facilityType}&fname=${MAR.facilityName}&reportedUser=${MAR.reportedUser}&reporteddate=${MAR.date}" method="post">
    <table style="width: 1200px; ">
    <tr>
    <tr>
    <td> MAR ID: </td>
    <td>  <c:out value="${MAR.marID}"/> </td>
    </tr>
    <tr>
    <td> Facility Name: </td>
    <td>  <c:out value="${MAR.facilityType}"/> </td>
    </tr>
    <tr>
    <td> Facility Type: </td>
    <td>  <c:out value="${MAR.facilityName}"/> </td>
    </tr>
    <tr>
    <td> Reported By: </td>
    <td>  <c:out value="${MAR.reportedUser}"/> </td>
    </tr>

    <tr>
    <td> Reported Date: </td>
    <td>  <c:out value="${MAR.date}"/> </td>
    </tr>
    <tr>
    <tr>
    <td> Urgency: </td>
     <td> 
    <select name="idUrgency">
          <c:forEach items="${URGENCY}" var="item" varStatus="status">
            <option value="${item.id}">${item.value}</option>
          </c:forEach>
    </select>
    </td>
    </tr>

    <tr>
    <td> Description (*): </td>
    <td> <input name="iddescription" value="<c:out value='${MAR.description}'/>" type="text" maxlength="16"> </td>
       	<td> <input name="assignedToIDerror"  value="<c:out value='${errorMsgs.descriptionErrorMsgs}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
   
    </tr>


    <tr>
    <td> Estimate Of Repair (*): </td>
    <td> 
    <select name="idestimateofRepair">
          <c:forEach items="${ESTIMATEOFREPAIR}" var="item" varStatus="status">
            <option value="${item.id}">${item.value}</option>
          </c:forEach>
    </select>
    </td>
   </tr>
   
   
   <tr>
    <td> Assigned To (*): </td>
    <td> 
    <select name="idassignedTo">
          <c:forEach items="${REPAIRLIST}" var="item" varStatus="status">
            <option value="${item.username}">${item.username}</option>
          </c:forEach>
    </select>
    </td>  
      	<td> <input name="assignedToIDerror"  value="<c:out value='${errorMsgs.assignedToErrorMsgs}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
    
   </tr>
    
    
    
   <tr>
    <td> Assigned Date (*): </td>
    <td> 
   <input type="text" name ="iddateTimePicker" id="datepicker">
    </td>   
      	<td> <input name="assignedDateIDerror"  value="<c:out value='${errorMsgs.assignedDatErrorMsgs}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
    
    </tr>
  
  
    <tr>
    
    
    <td colspan="2">(*) Mandatory field</td>
    </tr>
    </table>
    <input name="action" value="saveassignedmar&marid=${MAR.marID}&ftype=${MAR.facilityType}&fname=${MAR.facilityName}&reportedUser=${MAR.reportedUser}&reporteddate=${MAR.date}" type="hidden">
    <input type="submit" value="Assign MAR">
    </form>
</td>
</tr>
</table>


</body>
</html>