<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Tasks list</title>
</head>
<body>
    <form action="todo" method="POST">
                Task name:<input type="text" name="taskName" placeholder="Enter task name"/>
                <br/>
                Task category: <input type="text" name="taskCategory" placeholder="Enter task category"/>
                <br/>
                <input type="submit" value="Add task">
    </form>
    <form action="submit" method="POST">
             <table name="Things List">
                 <tr>
                     <th>Name</th>
                     <th>Category</th>
                     <th>Complete</th>
                 </tr>

                 <c:forEach items="${allTasks}" var="task">

                     <tr>
                         <td>${task.name}</td>
                         <td>${task.category}</td>
                         <td><input type="checkbox" name="done" value="${task.name}"/></td>
                     </tr>
                 </c:forEach>

             </table>

             <input id="update" type="submit" value="Update tasks"/>

     </form>
</body>
</html>