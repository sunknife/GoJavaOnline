<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Admin Menus</title>
</head>
<body>
<h1>Menus</h1>
<a href="/restaraunt-admin-1.0">Main</a>      <a href="/restaraunt-admin-1.0/menu">Menu</a> <a href="/restaraunt-admin-1.0/dish">Dishes</a> <a href="/restaraunt-admin-1.0/employee">Employees</a> <a href="/restaraunt-admin-1.0/stock">Store</a> <a href="/restaraunt-admin-1.0/order">Orders history</a>
<table>
    <tr>
        <th>Name</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${menus}" var="menu">
      <tr>
         <td>${menu.name}</td>
         <td><form action="/restaraunt-admin-1.0/menu?deleteMenuName=${menu.name}" method="POST"><input type="submit" value="Delete"></form><form action="/restaraunt-admin-1.0/menuEdit?menuName=${menu.name}" method="POST"><input type="submit" value="Edit"></form>
         </td>
      </tr>
        <table>
        <tr>
            <th>Name</th>
            <th>Weight</th>
            <th>Price</th>
        </tr>
        <c:forEach items="${menu.dishes}" var="dish">
            <tr>
                <td><a href="/restaraunt-admin-1.0/dish/${dish.name}">${dish.name}</a></td>
                <td>${dish.weight}</td>
                <td>${dish.cost}</td>
            </tr>
        </c:forEach>
        </table>
    </c:forEach>
</table>
<form action="/restaraunt-admin-1.0/menu?addMenu=true" method="POST">
                <input type="text" name="menuId" placeholder="menuId"/>
                <input type="text" name="menuName" placeholder="menuName"/>
                <input type="submit" value="Add Menu">
                </form>
</body>
</html>