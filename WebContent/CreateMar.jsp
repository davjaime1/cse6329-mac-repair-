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

        <form action="/mac_repair/CreateMarController?action=listFacilitiesNameOnly" method="post">

            <table border="1" class="myTable">
                <tr class="myTableRow">
                    <th class="myTableHead" style="width: 20px; ">Select Facility</th>
                    <th class="myTableHead" style="padding-right: 20px; text-align: left">Facility Name</th>
                </tr>

                <c:forEach items="${FACILITIES}" var="item" varStatus="status">
                    <tr class="myTableRow">
                        <td class="myTableCell" style="width: 20px; text-align: center">
                            <input type="radio" id="radioFacility${status.count}" name="radioFacility" value="${status.count}">
                        </td>
                        <td class="myTableCell" style="padding-right: 20px; ">
                            <c:out value="${item.name}" />
                        </td>
                    </tr>
                </c:forEach>
            </table>

            <br>

            <table border="1">
                <tr>
                    <th>Select Urgency</th>
                    <th>Urgency</th>
                </tr>

                <c:forEach items="${URGENCIES}" var="item" varStatus="status">
                    <tr>
                        <td><input type="radio" id="radioUrgency${status.count}" name="radioUrgency" value="${status.count}"></td>
                        <td><c:out value="${item.urgency}" /></td>
                    </tr>
                </c:forEach>
            </table>

            <h4>Description</h4>
            <textarea maxlength="120" required wrap></textarea>

            <input type="submit" id="submit" value="submit">

        </form>
    </div>
</body>

</html>