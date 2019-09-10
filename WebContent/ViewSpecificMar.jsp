<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Specific MAR</title>
</head>
<body>

<div style="float:right">
<form align="right" name="form1" method="post" action="index.jsp">
<label>
<input name="submit2" type="submit" id="submit2" value="Logout">
</label>
</form>
</div>

<div class="logo"><h1><a href="<c:url value='/' />">Mac Repair</a></h1></div>
<table>
  <tr>
   <td>
         <table border="1" class="myTable"> 
    
    <tr>
    <td> Facility Name: </td>
    <td> <c:out value="${COMPANIES.idcompany}" /> </td>
    </tr>

    <tr>
    <td> Facility Type: </td>
    <td> <c:out value="${COMPANIES.company_name}"/> </td>
    </tr>

    <tr>
    <td> Urgency: </td>
    <td> <c:out value="${COMPANIES.phone}" /> </td>
    </tr>

    <tr>
    <td> Description: </td>
    <td> <c:out value="${COMPANIES.email}" /> </td>
    </tr>
    
    <tr>
    <td> Reported By: </td>
    <td> <c:out value="${COMPANIES.email}" /> </td>
    </tr>
    
    <tr>
    <td> Date: </td>
    <td> <c:out value="${COMPANIES.email}" /> </td>
    </tr>
    
    <tr>
    <td> MAR Number: </td>
    <td> <c:out value="${COMPANIES.email}" /> </td>
    </tr>

    <tr>
    </tr>
    </table>
</td>
</tr>
</table>

<button onclick="window.location.href = 'ModifyMar.jsp';" class="btn default">Modify MAR</button>
<button onclick="window.location.href = 'DeleteMar.jsp';" class="btn default">Delete MAR</button>
<button onclick="window.location.href = 'AssignMar.jsp';" class="btn default">Assign MAR</button>


<li><a href="FM_Home.jsp"  target="_top"><span>Return to Homepage</span></a></li> 
</body>
</html>