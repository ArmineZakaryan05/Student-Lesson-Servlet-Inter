<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 6/18/2025
  Time: 3:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add lesson</title>
</head>
<body>
<form action="/addLesson" method="post">
    Name:<input type="text" name="name"><br>
    Duration:<input type="date" name="duration"><br>
    Lecturer Name:<input type="text" name="lecturer_name"><br>
    Price:<input type="number" name="price"><br>
    <input type="submit" value="Add">
</form>
</body>
</html>
