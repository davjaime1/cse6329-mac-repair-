<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Company form</title>
</head>
<body>
	<div class="logo"><h1><a href="<c:url value='/' />">Mac Repair</a></h1></div>
<!-- Change the action to page where the registeration is completed -->
    <form name="registerForm" action="/mac_repair/RegisterController?newUser" method="post">
    <table style="width: 1200px; ">
    <tr>
    <td> Username: </td>
    <td> <input name="username" value="<c:out value='${user.username}'/>" type="text" maxlength="16"> </td>
  	<!--<td> <input name="usernameError"  value="<c:out value='${errorMsgs.usernameError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
    -->
    </tr>

    <tr>
    <td> UTA ID: </td>
    <td> <input name="utaID" value="<c:out value='${user.utaID}'/>" type="text" maxlength="45">  </td>
 	<!--<td> <input name="utaIDError"  value="<c:out value='${errorMsgs.utaIDError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    -->
    </tr>

    <tr>
    <td> First Name: </td>
    <td> <input name="first" value="<c:out value='${user.first}'/>" type="text" maxlength="16">  </td>
  	<!--<td> <input name="firstError"  value="<c:out value='${errorMsgs.firstError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    -->
    </tr>

    <tr>
    <td> Last Name: </td>
    <td> <input name="last" value="<c:out value='${user.last}'/>" type="text" maxlength="45">  </td>
  	<!--<td> <input name="lastError"  value="<c:out value='${errorMsgs.lastError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    -->
    </tr>
    
    <tr>
    <td> Password: </td>
    <td> <input name="password" value="<c:out value='${user.password}'/>" type="text" maxlength="16"> </td>
  	<!--<td> <input name="companyIDerror"  value="<c:out value='${errorMsgs.passwordError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
    -->
    </tr>
    
    <tr>
    <td> Role: </td>
    <td> <select>
  	<option value="Facility Manager">Facility Manager</option>
  	<option value="Repairer">Repairer</option>
  	<option value="Admin">Admin</option>
  	<option value="User">User</option>
  	</select>
  	</td>
  	<td> <input name="roleError"  value="<c:out value='${errorMsgs.roleerror}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td> Address: </td>
    <td> <input name="address" value="<c:out value='${user.address}'/>" type="text" maxlength="16"> </td>
  	<td> <input name="addressError"  value="<c:out value='${errorMsgs.addressError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
    </tr>

	<tr>
    <td> City: </td>
    <td> <input name="city" value="<c:out value='${user.city}'/>" type="text" maxlength="16"> </td>
  	<td> <input name="cityError"  value="<c:out value='${errorMsgs.cityError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
    </tr>

	<tr>
    <td> State: </td>
    <td> <input name="state" value="<c:out value='${user.state}'/>" type="text" maxlength="16"> </td>
  	<td> <input name="stateError"  value="<c:out value='${errorMsgs.stateError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
    </tr>
	
	<tr>
    <td> Zip: </td>
    <td> <input name="zip" value="<c:out value='${user.zip}'/>" type="text" maxlength="16"> </td>
  	<td> <input name="zipError"  value="<c:out value='${errorMsgs.zipError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
    </tr>
	
	<tr>
    <td> Phone: </td>
    <td> <input name="phone" value="<c:out value='${user.phone}'/>" type="text" maxlength="16"> </td>
  	<td> <input name="phoneError"  value="<c:out value='${errorMsgs.phoneError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
    </tr>
	
	<tr>
    <td> Email: </td>
    <td> <input name="email" value="<c:out value='${user.email}'/>" type="text" maxlength="16"> </td>
  	<td> <input name="emailError"  value="<c:out value='${errorMsgs.emailError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
    </tr>
	
    </table>
    
    <input type="Submit" value="Register">
    </form>
    
    <li><a href="FM_Home.jsp"  target="_top"><span>Facility Manager Homepage</span></a></li>    
    
</body>
</html>