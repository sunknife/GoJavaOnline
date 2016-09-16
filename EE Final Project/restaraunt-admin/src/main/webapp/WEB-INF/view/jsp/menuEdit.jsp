<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Admin Menus</title>
</head>
<body>
<h1>${menu.name}</h1>
<a href="/restaraunt-admin-1.0">Main</a>      <a href="/restaraunt-admin-1.0/menu">Menu</a> <a href="/restaraunt-admin-1.0/dish">Dishes</a> <a href="/restaraunt-admin-1.0/employee">Employees</a> <a href="/restaraunt-admin-1.0/stock">Store</a> <a href="/restaraunt-admin-1.0/order">Orders history</a>
        <table>
        <tr>
            <th>Name</th>
            <th>Weight</th>
            <th>Price</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${menu.dishes}" var="dish">
            <tr>
                <td><a href="/restaraunt-admin-1.0/dish/${dish.name}">${dish.name}</a></td>
                <td>${dish.weight}</td>
                <td>${dish.cost}</td>
                <td><form action="/restaraunt-admin-1.0/menuEdit?deleteDishFromMenu=${dish.id}&menuId=${menu.id}" method="POST">
                                 <input type="submit" value="Delete">
                                 </form>
                </td>
            </tr>
        </c:forEach>
        </table>
        <table>
        <tr>
        <th>Dishes to Add</th>
        </tr>
        <tr>
        <td>
        <form action="/restaraunt-admin-1.0/menuEdit?addDishToMenu=true&menuId=${menu.id}" method = "POST">
        <select id="availableDishes" name="availableDishes">
                    <c:forEach var="dish" items="${allDishes}">
                        <option value="${dish.name}">${dish.name}</option>
                    </c:forEach>
        </select>
        <input type="submit" value="Add">
        </form>
        </td>
        </tr>
        </table>
        <h2>${test}</h2>
</body>
</html>