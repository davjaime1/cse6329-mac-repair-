<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Specific MAR</title>
</head>
<body>
<div class="logo"><h1><a href="<c:url value='/' />">Mac Repair</a></h1></div>

<table>
  <tr>
   <td>
         <table border="1" class="myTable"> 
    
    <tr>
    <td> Username: </td>
    <td> <c:out value="${COMPANIES.idcompany}" /> </td>
    </tr>

    <tr>
    <td> UTA ID: </td>
    <td> <c:out value="${COMPANIES.company_name}"/> </td>
    </tr>

    <tr>
    <td> First Name: </td>
    <td> <c:out value="${COMPANIES.phone}" /> </td>
    </tr>

    <tr>
    <td> Last Name: </td>
    <td> <c:out value="${COMPANIES.email}" /> </td>
    </tr>
    
    <tr>
    <td> Password: </td>
    <td> <c:out value="${COMPANIES.email}" /> </td>
    </tr>
    
    <tr>
    <td> Role: </td>
    <td> <c:out value="${COMPANIES.email}" /> </td>
    </tr>
    
    <tr>
    <td> Address: </td>
    <td> <c:out value="${COMPANIES.email}" /> </td>
    </tr>
    
    <tr>
    <td> City: </td>
    <td> <c:out value="${COMPANIES.email}" /> </td>
    </tr>
    
    <tr>
    <td> State: </td>
    <td> <c:out value="${COMPANIES.email}" /> </td>
    </tr>
    
    <tr>
    <td> Zip: </td>
    <td> <c:out value="${COMPANIES.email}" /> </td>
    </tr>
    
    <tr>
    <td> Phone: </td>
    <td> <c:out value="${COMPANIES.email}" /> </td>
    </tr>
    
    <tr>
    <td> Email: </td>
    <td> <c:out value="${COMPANIES.email}" /> </td>
    </tr>

    <tr>
    </tr>
    </table>
    
</td>
</tr>
</table>

<li><a href="FM_Home.jsp"  target="_top"><span>Return to Homepage</span></a></li> 
</body>
</html>