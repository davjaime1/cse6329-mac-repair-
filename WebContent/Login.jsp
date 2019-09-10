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
    <form name="registerForm" action="/cse6329/UsersController?login" method="post">
    <table style="width: 400px; ">
    <tr>
    <td> Username: </td>
    <td> <input name="username" value="<c:out value='${users.username}'/>" type="text" maxlength="16"> </td>
  	<!--<td> <input name="usernameError"  value="<c:out value='${errorMsgs.usernameError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
    -->
    </tr>

    <tr>
    <td> Password: </td>
    <td> <input name="password" value="<c:out value='${users.password}'/>" type="password" maxlength="16"> </td>
  	<!--<td> <input name="companyIDerror"  value="<c:out value='${errorMsgs.passwordError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
    -->
    </tr>
	
    </table>
    
    <input type="Submit" value="login">
    </form>
    <li><a href="FM_Home.jsp"  target="_top"><span>Facility Manager Homepage</span></a></li>    
</body>
</html>