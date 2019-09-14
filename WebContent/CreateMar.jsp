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

    <div class="col-md-4">

        <form action="/mac_repair/CreateMarController?action=SubmitMarAction" method="post">

            <p>
                Select Facility:&nbsp;
                <select name="facilityDropDown" required>
                    <c:forEach items="${FACILITIES}" var="facility">
                        <option value="${facility.name}">${facility.name}</option>
                    </c:forEach>
                </select>
            </p>

            <p>
                Select Urgency:&nbsp;
                <select name="urgencyDropDown" required>
                    <c:forEach items="${URGENCIES}" var="urgency">
                        <option value="${urgency.urgency}">${urgency.urgency}</option>
                    </c:forEach>
                </select>
            </p>

            <p>
                Description<br>
                <textarea name=descriptionTextArea maxlength="120" required wrap="soft"></textarea>
                <input type="submit" id="submitButton" value="submit">
            </p>

        </form>

    </div>
</body>

</html>