<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User Home > ${username}</title>
</head>

<body>

    <header>
        <h1>User Home > ${username}</h1>
    </header>

    <section>
        <ul>
            <li><a href="/mac_repair/MarController?action=NewMarAction">Create MAR</a></li>
            <li><a href="/mac_repair/MarController?action=ListMarsAction">View MARs</a></li>
            <li><a href="/mac_repair/UserController?action=viewProfile">View Profile</a></li>
            <li><a href="/mac_repair/UserController?action=updateProfileView">Update Profile</a></li>
            <li><a href="/mac_repair/UserController?action=logOut">Log Out</a></li>
        </ul>
    </section>

</body>

</html>