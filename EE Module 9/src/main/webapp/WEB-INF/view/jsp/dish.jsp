<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Restaraunt</title>
</head>
<body>
<h1>${dish.name}</h1>
<table>
    <tr>
        <th>Name</th>
        <th>Weight</th>
        <th>Price</th>
        <th>Category</th>
    </tr>
        <tr>
            <td>${dish.name}></td>
            <td>${dish.weight}</td>
            <td>${dish.cost}</td>
            <td>${dish.category}</td>
        </tr>
</table>
<table>
<caption>${dish.name} Ingredients</caption>
    <tr>
        <th>Name</th>
    </tr>
    <c:forEach items="${dish.ingredients}" var="ingredient">
        <tr>
            <td>${ingredient.name}></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>