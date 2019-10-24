<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
    <title>Create MAR</title>
</head>

<body>
    <header>
        <h2>Create MAR</h2>
    </header>

    <form action="/mac_repair/MarController?action=SubmitMarAction" method="post">

        <table border="1">
            <tr>
                <td>Select Facility</td>
                <td>
                    <select name="facilityDropDown" required>
                        <c:forEach items="${FACILITIES}" var="facility">
                            <option value="${facility.facilityName}">
                                <c:out value="${facility.facilityName}" />
                            </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>

            <tr>
                <td>Select Urgency</td>
                <td>
                    <select name="urgencyDropDown" required>
                        <c:forEach items="${URGENCIES}" var="urgency">
                            <option value="${urgency.value}">
                                <c:out value="${urgency.value}" />
                            </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
        </table>

        <p>
            Description<br>
            <textarea name=descriptionTextArea maxlength="120" wrap="soft"></textarea>
            <font color="red">
                <c:out value="${ERR_MSG}" />
            </font>
        </p>

        <p>
            <input type="submit" id="submitButton" value="submit">
        </p>

        <ul>
            <li><a href="/mac_repair/UserController?action=ToHomePage">Back to Home</a></li>
        </ul>

    </form>
</body>

</html>