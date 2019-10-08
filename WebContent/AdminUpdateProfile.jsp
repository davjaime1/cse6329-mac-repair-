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
<title>Update User Profile</title>
 
</head>
<body>
<input name="errMsg"  value="<c:out value='${errorMsgs.errorMsg}'/>" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
<table>
  <tr>
   <td>
    <form name="companyForm" action="/mac_repair/AdminSpecificUserController?updateProfile&ApplyNewValuesAction=&idusername=${user.username}&idutaID=${user.utaId}" method="post">
    <table style="width: 1200px; ">
    
    <tr>
    <td> User Name: </td>
    <td>  <c:out value="${user.username}"/> </td>
    </tr>
    <tr>
    <td> UTA ID: </td>
    <td>  <c:out value="${user.utaId}"/> </td>
    </tr>
 
    <tr>
    <td> First Name (*): </td>
    <td>  <c:out value="${olduser.firstName}"/> </td>
    <td> <input name="idfirstname" value="<c:out value='${user.firstName}'/>" type="text" maxlength="16"> </td>
  	<td> <input name="userIDerror"  value="<c:out value='${errorMsgs.firstnameError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
    </tr>
    
    
    <tr>
    <td> Last Name (*): </td>
    <td>  <c:out value="${olduser.lastName}"/> </td>
    
    <td> <input name="idlastname" value="<c:out value='${user.lastName}'/>" type="text" maxlength="16"> </td>
  	<td> <input name="userIDerror"  value="<c:out value='${errorMsgs.lastnameError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
       <td> Password(*): </td>
           <td>  <c:out value="${olduser.password}"/> </td>
       
    <td> <input name="idpassword" value="<c:out value='${user.password}'/>" type="text" maxlength="16"> </td>
  	<td> <input name="userIDerror"  value="<c:out value='${errorMsgs.passwordError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
       <td> Address (*): </td>
           <td>  <c:out value="${olduser.address}"/> </td>
       
    <td> <input name="idaddress" value="<c:out value='${user.address}'/>" type="text" maxlength="200"> </td>
  	<td> <input name="userIDerror"  value="<c:out value='${errorMsgs.addressError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
          <td> City (*): </td>
              <td>  <c:out value="${olduser.city}"/> </td>
          
    <td> <input name="idcity" value="<c:out value='${user.city}'/>" type="text" maxlength="16"> </td>
  	<td> <input name="userIDerror"  value="<c:out value='${errorMsgs.cityError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td> State (*): </td>
            <td>  <c:out value="${olduser.state}"/> </td>
    
    <td> 
    <select name="idstate">
    
          <c:forEach items="${STATE}" var="item" varStatus="status">
            <option value="${item.id}">${item.name}</option>
          </c:forEach>
    </select>
    </td>
    
    </tr>
    <tr>
       <td> Zip (*): </td>
               <td>  <c:out value="${olduser.zip}"/> </td>
       
    <td> <input name="idzip" value="<c:out value='${user.zip}'/>" type="text" maxlength="16"> </td>
  	<td> <input name="userIDerror"  value="<c:out value='${errorMsgs.zipError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
    </tr>
    
       <tr>
        <td> Phone (*): </td>
                <td>  <c:out value="${olduser.phone}"/> </td>
        
    <td> <input name="idphone" value="<c:out value='${user.phone}'/>" type="text" maxlength="16"> </td>
  	<td> <input name="userIDerror"  value="<c:out value='${errorMsgs.phoneError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
        <td> E-mail (*): </td>
                <td>  <c:out value="${olduser.email}"/> </td>
        
    <td> <input name="idemail" value="<c:out value='${user.email}'/>" type="text" maxlength="45"> </td>
  	<td> <input name="userIDerror"  value="<c:out value='${errorMsgs.emailError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td> Role (*): </td>
            <td>  <c:out value="${olduser.role}"/> </td>
    
    <td> 
    <select name="idrole">
          <c:forEach items="${ROLE}" var="item" varStatus="status">
            <option value="${item.id}">${item.name}</option>
          </c:forEach>
    </select>
    </td>
    
    </tr>

  
    
    <tr>
    <td colspan="2">(*) Mandatory field</td>
    </tr>
    </table>
    <input name="action" value="ApplyNewValuesAction" type="hidden">
    <input type="submit" value="Update User">
    </form>
</td>
</tr>
</table>
<ul>
        <li><a href="AdminHome.jsp">Admin Home</a></li>
</ul>

</body>
</html>