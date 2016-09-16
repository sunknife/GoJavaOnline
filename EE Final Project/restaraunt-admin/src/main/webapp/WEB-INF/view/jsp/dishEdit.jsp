<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Admin Dishes</title>
</head>
<body>
<h1>${dish.name}</h1>
<a href="/restaraunt-admin-1.0">Main</a> <a href="/restaraunt-admin-1.0/menu">Menu</a> <a href="/restaraunt-admin-1.0/dish">Dishes</a> <a href="/restaraunt-admin-1.0/employee">Employees</a> <a href="/restaraunt-admin-1.0/stock">Store</a> <a href="/restaraunt-admin-1.0/order">Orders history</a>
<table>
    <tr>
        <th>Name</th>
        <th>Weight</th>
        <th>Price</th>
        <th>Category</th>
    </tr>
        <tr>
            <td>${dish.name}</td>
            <td>${dish.weight}</td>
            <td>${dish.cost}</td>
            <td>${dish.category}</td>
        </tr>
</table>
<table>
<caption>Ingredients</caption>
    <tr>
        <th>Name</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${dish.ingredients}" var="ingredient">
    <tr>
        <td>${ingredient.name}</td>
        <td><form action="/restaraunt-admin-1.0/dishEdit?dishId=${dish.id}&deleteFromDish=${ingredient.id}" method="POST">
                                         <input type="submit" value="Delete">
                                         </form></td>
    </tr>
    </c:forEach>
</table>
<table>
        <tr>
        <th>Add Ingredient</th>
        </tr>
        <tr>
        <td>
        <form action="/restaraunt-admin-1.0/dishEdit?addIngredient=true&dishId=${dish.id}" method = "POST">
        <select id="availableIngredients" name="availableIngredients">
                    <c:forEach var="ingredient" items="${allIngredients}">
                        <option value="${ingredient.ingredient.name}">${ingredient.ingredient.name}</option>
                    </c:forEach>
        </select>
        Quantity<input type="text" name = "ingredientQuantity" value="1">
        <input type="submit" value="Add">
        </form>
        </td>
        </tr>
        </table>
</body>
</html>