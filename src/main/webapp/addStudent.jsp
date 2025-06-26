<%@ page import="org.example.studentlessonservletinter.model.Lesson" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 6/18/2025
  Time: 3:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add student</title>
</head>
<body>
<%List<Lesson> lessons = (List<Lesson>) request.getAttribute("lessons");%>
<form action="/addStudent" method="post">
    Name:<input type="text" name="name"><br>
    Surname:<input type="text" name="surname"><br>
    Email:<input type="email" name="email"><br>
    Age:<input type="number" name="age"><br>
    Lesson:<select name="lesson_id">
    <%for (Lesson lesson : lessons) {%>
    <option value="<%=lesson.getId()%>"><%=lesson.getName()%>
    </option>
    <%}%>
</select><br>
    <input type="submit" value="Add">
</form>
</body>
</html>
