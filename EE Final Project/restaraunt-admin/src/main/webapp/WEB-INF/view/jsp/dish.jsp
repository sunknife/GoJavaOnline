<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Admin Dishes</title>
</head>
<body>
<h1>Dishes</h1>
<a href="/restaraunt-admin-1.0">Main</a> <a href="/restaraunt-admin-1.0/menu">Menu</a> <a href="/restaraunt-admin-1.0/dish">Dishes</a> <a href="/restaraunt-admin-1.0/employee">Employees</a> <a href="/restaraunt-admin-1.0/stock">Store</a> <a href="/restaraunt-admin-1.0/order">Orders history</a>
<c:forEach items="${dishes}" var="dish">
<table>
    <tr>
        <th>Name</th>
        <th>Weight</th>
        <th>Price</th>
        <th>Category</th>
        <th>Delete</th>
        <th>Edit</th>
    </tr>
        <tr>
            <td>${dish.name}</td>
            <td>${dish.weight}</td>
            <td>${dish.cost}</td>
            <td>${dish.category}</td>
            <td><form action="/restaraunt-admin-1.0/dish?deleteDishName=${dish.name}" method="POST">
                             <input type="submit" value="Delete">
                             </td>
            <td></form> <form action="/restaraunt-admin-1.0/dishEdit?dishName=${dish.name}" method="POST">
                                                                                  <input type="submit" value="Edit">
                                                                                  </form>
            </td>
        </tr>
</table>
</c:forEach>
<form action="/restaraunt-admin-1.0/dish?addDish=true" method="POST">
                <input type="text" name="dishId" placeholder="dishId"/>
                <input type="text" name="dishName" placeholder="dishName"/>
                <input type="text" name="dishCategory" placeholder="dishCategory"/>
                <input type="text" name="dishCost" placeholder="dishCost"/>
                <input type="text" name="dishWeight" placeholder="dishWeight"/>
                <input type="submit" value="Add Dish">
                </form>
</body>
</html>