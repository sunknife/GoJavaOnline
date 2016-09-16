<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Admin Employees</title>
</head>
<body>
<h1>Employees</h1>
<a href="/restaraunt-admin-1.0">Main</a>      <a href="/restaraunt-admin-1.0/menu">Menu</a> <a href="/restaraunt-admin-1.0/dish">Dishes</a> <a href="/restaraunt-admin-1.0/employee">Employees</a> <a href="/restaraunt-admin-1.0/stock">Store</a> <a href="/restaraunt-admin-1.0/order">Orders history</a>
<table>
    <tr>
        <th>Photo</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Birth Date</th>
        <th>Telephone</th>
        <th>Position_Id</th>
        <th>Salary</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${employees}" var="employee">
    <form action="/restaraunt-admin-1.0/employee?updateId=${employee.id}" method="POST">
        <tr>
            <td><img src="/restaraunt-admin-1.0/resources/images/face.png"></td>
            <td><input type="text" name="employeeName" value="${employee.name}"/></td>
            <td><input type="text" name="employeeSurname" value="${employee.surname}"/></td>
            <td><input type="text" name="employeeBirth" value="${employee.birthDate}"/></td>
            <td><input type="text" name="employeeTelephone" value="${employee.telephoneNumber}"/></td>
            <td><input type="text" name="employeePosition" value="${employee.positionID}"/></td>
            <td><input type="text" name="employeeSalary" value="${employee.salary}"/></td>
            <td><input type="submit" value="Update"></td>
        </tr>
       </form>
    </c:forEach>
</table>
<form action="/restaraunt-admin-1.0/employee?addNew=true" method="POST">
            <input type="text" name="employeeId" placeholder="Id"/>
            <input type="text" name="employeeName" placeholder="Name"/>
            <input type="text" name="employeeSurname" placeholder="Surname"/>
            <input type="text" name="employeeBirth" placeholder="BirthDate"/>
            <input type="text" name="employeeTelephone" placeholder="TelephoneNumber"/>
            <input type="text" name="employeePosition" placeholder="PositionID"/>
            <input type="text" name="employeeSalary" placeholder="Salary"/>
            <input type="submit" value="Add Employee">
       </form>
</body>
</html>