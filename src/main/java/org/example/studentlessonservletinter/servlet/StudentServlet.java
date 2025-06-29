package org.example.studentlessonservletinter.servlet;

import org.example.studentlessonservletinter.model.Student;
import org.example.studentlessonservletinter.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {
    private StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> allStudents = studentService.getAllStudents();
        req.setAttribute("students", allStudents);
        req.getRequestDispatcher("/students.jsp").forward(req, resp);
    }
}