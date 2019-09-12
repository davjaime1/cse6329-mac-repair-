<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User Home</title>
</head>

<body>

    <header>
        <h2>User Home</h2>
    </header>

    <section>

        <ul>
            <% // Anchors will always do a doGet() %>
            <li><a href="/mac_repair/CreateMarController?action=NewMarAction">Create MAR</a></li>
            <li><a href="ViewProfile.jsp">View Profile</a></li>
            <li><a href="UpdateProfile.jsp">Update Profile</a></li>
        </ul>

    </section>

</body>

</html>