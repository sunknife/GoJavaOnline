<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Admin Stock</title>
</head>
<body>
<h1>Stock</h1>
<a href="/restaraunt-admin-1.0">Main</a>      <a href="/restaraunt-admin-1.0/menu">Menu</a> <a href="/restaraunt-admin-1.0/dish">Dishes</a> <a href="/restaraunt-admin-1.0/employee">Employees</a> <a href="/restaraunt-admin-1.0/stock">Store</a> <a href="/restaraunt-admin-1.0/order">Orders history</a>
<table>
    <tr>
        <th>Name</th>
        <th>Quantity</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${ingredients}" var="ingredient">
        <tr>
            <td>${ingredient.ingredient.name}</td>
            <td><form action="/restaraunt-admin-1.0/stock?updateId=${ingredient.ingredientId}" method="POST">
                <input type="text" name="${ingredient.ingredientId}" value="${ingredient.quantity}"/>
                <input type="submit" value="Update">
                </form>
            </td>
            <td><form action="/restaraunt-admin-1.0/stock?deleteIngredientId=${ingredient.ingredientId}" method="POST">
                             <input type="submit" value="Delete">
                             </form></td>
        </tr>
    </c:forEach>
</table>
<form action="/restaraunt-admin-1.0/stock?addNew=true" method="POST">
                <input type="text" name="ingredientId" placeholder="Id"/>
                <input type="text" name="ingredientName" placeholder="Name"/>
                <input type="text" name="ingredientQuantity" placeholder="Quantity"/>
                <input type="submit" value="Add Ingredient">
                </form>
</body>
</html>