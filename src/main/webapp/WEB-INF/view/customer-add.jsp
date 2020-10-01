<%--
  Created by IntelliJ IDEA.
  User: Bhumika_Satpathy
  Date: 09/09/20
  Time: 6:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Save Customer</title>
</head>
<body>
    <h1> Save Customer </h1>

    <form:form action="saveCustomer" modelAttribute="customer" method="POST">
        <table>
        <%-- Needed because otherwise id would be removed from the customer attribute  --%>
            <tr>
                <td><form:hidden path="id"/></td>
            </tr>



            <tr>
                <td><label>First Name: </label></td>
                <td><form:input path="firstName"></form:input></td>
            </tr>
            <tr>
                <td><label>Last Name: </label></td>
                <td><form:input path="lastName"></form:input></td>
            </tr>
            <tr>
                <td><label>Email: </label></td>
                <td><form:input path="email"></form:input></td>
            </tr>
            <input type="submit" value="Save"/>
        </table>
    </form:form>
    <a href="${pageContext.request.contextPath}/customer/list">Back to Home</a>
</body>
</html>
