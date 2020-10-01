<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <title>List Customers</title>
</head>

<body>
<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer RelationShip Manager</h2>
    </div>
</div>

<div id="container">

    <div id="content">

        <input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'"/>

        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
            </tr>

            <c:forEach var="tempCustomer" items="${customers}">

                <%--  Add a url to redirect to this particulat link on clicking update  --%>
                <c:url var="updateLink" value="/customer/showFormForUpdate">
                    <c:param name="customerId" value="${tempCustomer.id}"/>
                </c:url>

                <%--  Add a url to redirect to this particulat link on clicking delete  --%>
                <c:url var="delete" value="/customer/deleteCustomer">
                    <c:param name="customerId" value="${tempCustomer.id}"/>
                </c:url>

                <tr>
                    <td>${tempCustomer.firstName} </td>
                    <td>${tempCustomer.lastName} </td>
                    <td>${tempCustomer.email} </td>
                    <td>
                        <a href="${updateLink}">Update</a> |
                        <a href="${delete}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

</div>

</body>

</html>