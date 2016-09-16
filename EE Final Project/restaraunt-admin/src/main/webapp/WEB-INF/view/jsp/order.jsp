<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Admin Orders</title>
</head>
<body>
<h1>Orders</h1>
<a href="/restaraunt-admin-1.0">Main</a>      <a href="/restaraunt-admin-1.0/menu">Menu</a> <a href="/restaraunt-admin-1.0/dish">Dishes</a> <a href="/restaraunt-admin-1.0/employee">Employees</a> <a href="/restaraunt-admin-1.0/stock">Store</a> <a href="/restaraunt-admin-1.0/order">Orders history</a>

<table>
    <tr>
        <th>ID</th>
        <th>Waiter ID</th>
        <th>Table Number</th>
    </tr>
    <c:forEach items="${orders}" var="order">
        <tr>
            <td>${order.id}</td>
            <td>${order.employeeId}</td>
            <td>${order.tableNumber}</td>
        </tr>
    </c:forEach>
</table>
<form action="/restaraunt-admin-1.0/order?filter=true" method = "POST">
        <select id="filterName" name="filterName">
                        <option value="Date">Filter by date</option>
                        <option value="Waiter">Filter by Waiter</option>
                        <option value="Table">Filter by Table</option>
        </select>
        <input type="text" name="filterValue" placeholder="Search here"/>
        <input type="submit" value="Filter">
        </form>
</body>
</html>