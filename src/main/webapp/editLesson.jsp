<%@ page import="org.example.studentlessonservletinter.model.Lesson" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 6/18/2025
  Time: 3:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit lesson</title>
</head>
<body>
<%Lesson lesson = (Lesson) request.getAttribute("lesson");%>
<form action="/editLesson" method="post">
    <input type="hidden" name="lesson_id" value="<%= lesson.getId()%>"><br>
    Name: <input type="text" name="name" value="<%= lesson.getName() %>"><br>
    Duration: <input type="text" name="duration" value="<%= lesson.getDuration() %>"><br>
    Lecturer name: <input type="text" name="lecturer_name" value="<%= lesson.getLecturerName() %>"><br>
    Price: <input type="number" name="price" value="<%= lesson.getPrice() %>"><br>
</form>
</body>
</html>
