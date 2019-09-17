<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Admin Home</title>
</head>

<body>
    <header>
        <h2>Admin Home</h2>
    </header>

    <ul>
      <li><a href="/mac_repair/AdminController?action=SearchUsersAction">Search Users</a></li>
      <li><a href="Login.jsp">Logout</a></li>
      <li><a href="/mac_repair/UserController?action=viewProfile"  target="_top"><span>View Profile</span></a></li>
      <li><a href="/mac_repair/UserController?action=updateProfile"  target="_top"><span>Update Profile</span></a></li>
       <li><a href="/mac_repair/UserController?action=logOut"  target="_top"><span>Log Out</span></a></li>
    </ul>
</body>

</html>