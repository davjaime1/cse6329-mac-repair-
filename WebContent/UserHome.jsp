<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User Home > ${username}</title>
</head>

<body>

    <header>
        <h2>User Home > ${username}</h2>
    </header>

    <section>

        <ul>
            <li><a href="/mac_repair/MarController?action=NewMarAction">Create MAR</a></li>
            <li><a href="/mac_repair/MarController?action=ViewMarsAction">View MARs</a></li>
            <li><a href="/mac_repair/UserController?action=viewProfile" target="_top"><span>View Profile</span></a></li>
            <li><a href="/mac_repair/UserController?action=updateProfile" target="_top"><span>Update Profile</span></a></li>
            <li><a href="/mac_repair/UserController?action=logOut" target="_top"><span>Log Out</span></a></li>
        </ul>

    </section>

</body>

</html>