<%@ page import="org.example.studentlessonservletinter.model.Student" %>
<%@ page import="java.util.List" %>
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
    <title>Edit Student</title>
</head>
<body>
<%
    Student student = (Student) request.getAttribute("student");
    List<Lesson> lessons = (List<Lesson>) request.getAttribute("lessons");
%>
<form action="/editStudent" method="post">
    <input type="hidden" name="id" value="<%=student.getId()%>"><br>
    Name: <input type="text" name="name" value="<%=student.getName()%>"><br>
    Surname:<input type="text" name="surname" value="<%=student.getSurname()%>"><br>
    Email: <input type="email" name="email" value="<%=student.getEmail()%>"><br>
    Age: <input type="number" name="age" value="<%=student.getAge()%>"><br>
    Lesson:< select name="lesson_id">
        <%for (Lesson lesson : lessons) {
    boolean selected = lesson.getId() == student.getLesson().getId();
      %>
    <option value="<%=lesson.getId()%>" <%= selected ? "selected" : ""%>
    <%=lesson.getName()%>
            </option>
                <%  }%>
    </select><br>
    <input type="submit" value="Edit student">
</form>
</body>
</html>
