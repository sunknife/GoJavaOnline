<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Restaraunt Employees</title>
</head>
<body>
<h1>Restaraunt Employees</h1>
<a href="/web-restaraunt-1.0">Main</a>      <a href="/web-restaraunt-1.0/scheme">Scheme</a> <a href="/web-restaraunt-1.0/employees">Employees</a> <a href="/web-restaraunt-1.0/contacts">Contacts</a>
<table>
    <tr>
        <th>Name</th>
        <th>Photo</th>
    </tr>
    <c:forEach items="${employees}" var="employee">
        <tr>
            <td>${employee.name}</td>
            <td><img src="/web-restaraunt-1.0/resources/images/face.png"></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>