<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Register</title>
</head>

<body>

    <h1>Register</h1>

    <form name="companyForm" action="/mac_repair/UserController?action=registerUser" method="post">
        <p>
            <font color="red">
                <c:out value='${errorMsgs.errorMsg}' />
            </font>
            <table>
                <tr>
                    <td> Username: </td>
                    <td> <input name="idusername" value="<c:out value='${user.username}'/>" type="text"> </td>
                    <td>
                        <font color="red">
                            <c:out value='${errorMsgs.usernameError}' />
                        </font>
                    </td>
                </tr>

                <tr>
                    <td> UTA ID: </td>
                    <td> <input name="idutaID" value="<c:out value='${user.id}'/>" type="text"> </td>
                    <td>
                        <font color="red">
                            <c:out value='${errorMsgs.idError}' />
                        </font>
                    </td>
                </tr>

                <tr>
                    <td> First Name: </td>
                    <td> <input name="idfirstname" value="<c:out value='${user.firstname}'/>" type="text"> </td>
                    <td>
                        <font color="red">
                            <c:out value='${errorMsgs.firstnameError}' />
                        </font>
                    </td>
                </tr>

                <tr>
                    <td> Last Name: </td>
                    <td> <input name="idlastname" value="<c:out value='${user.lastname}'/>" type="text"> </td>
                    <td>
                        <font color="red">
                            <c:out value='${errorMsgs.lastnameError}' />
                        </font>
                    </td>
                </tr>

                <tr>
                    <td> Password: </td>
                    <td> <input name="idpassword" value="<c:out value='${user.password}'/>" type="text"> </td>
                    <td>
                        <font color="red">
                            <c:out value='${errorMsgs.passwordError}' />
                        </font>
                    </td>
                </tr>

                <tr>
                    <td> Address: </td>
                    <td> <input name="idaddress" value="<c:out value='${user.address}'/>" type="text"> </td>
                    <td>
                        <font color="red">
                            <c:out value='${errorMsgs.addressError}' />
                        </font>
                    </td>
                </tr>

                <tr>
                    <td> City: </td>
                    <td> <input name="idcity" value="<c:out value='${user.city}'/>" type="text"> </td>
                    <td>
                        <font color="red">
                            <c:out value='${errorMsgs.cityError}' />
                        </font>
                    </td>
                </tr>

                <tr>
                    <td> State: </td>
                    <td>
                        <select name="idstate">
                            <c:forEach items="${STATE}" var="item" varStatus="status">
                                <option value="${item.id}">
                                    <c:out value='${item.value}' />
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td> Zip: </td>
                    <td> <input name="idzip" value="<c:out value='${user.zip}'/>" type="text"> </td>
                    <td>
                        <font color="red">
                            <c:out value='${errorMsgs.zipError}' />
                        </font>
                    </td>
                </tr>

                <tr>
                    <td> Phone: </td>
                    <td> <input name="idphone" value="<c:out value='${user.phone}'/>" type="text"> </td>
                    <td>
                        <font color="red">
                            <c:out value='${errorMsgs.phoneError}' />
                        </font>
                    </td>
                </tr>

                <tr>
                    <td> E-mail: </td>
                    <td> <input name="idemail" value="<c:out value='${user.email}'/>" type="text"> </td>
                    <td>
                        <font color="red">
                            <c:out value='${errorMsgs.emailError}' />
                        </font>
                    </td>
                </tr>

                <tr>
                    <td> Role: </td>
                    <td>
                        <select name="idrole">
                            <c:forEach items="${ROLE}" var="item" varStatus="status">
                                <option value="${item.id}">
                                    <c:out value='${item.value}' />
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </table>
        </p>

        <p>
            <input type="submit" value="Register">
        </p>

    </form>

    <p>
        <ul>
            <li><a href="index.jsp">Back to Login</a></li>
        </ul>
    </p>

</body>

</html>