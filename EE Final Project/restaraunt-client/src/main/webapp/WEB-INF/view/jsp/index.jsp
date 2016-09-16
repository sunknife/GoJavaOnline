<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Restaraunt</title>
</head>
<body>
<h1>Restaraunt</h1>
<a href="/restaraunt-client-1.0">Main</a>      <a href="/restaraunt-client-1.0/scheme">Scheme</a> <a href="/restaraunt-client-1.0/employees">Employees</a> <a href="/restaraunt-client-1.0/contacts">Contacts</a>
<c:forEach items="${menus}" var="menu">
<table>
    <tr>
        <th>Name</th>
        <th>Weight</th>
        <th>Price</th
    </tr>
    <c:forEach items="${menu.dishes}" var="dish">
        <tr>
            <td><a href="/restaraunt-client-1.0/dish?dishName=${dish.name}">${dish.name}</a></td>
            <td>${dish.weight}</td>
            <td>${dish.cost}</td>
        </tr>
    </c:forEach>
</table>
</c:forEach>
</body>
</html>