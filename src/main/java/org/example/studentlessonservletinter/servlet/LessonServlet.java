package org.example.studentlessonservletinter.servlet;

import org.example.studentlessonservletinter.model.Lesson;
import org.example.studentlessonservletinter.service.LessonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/lessons")
public class LessonServlet extends HttpServlet {
    private LessonService lessonService = new LessonService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Lesson> allLessons = lessonService.getAllLessons();
        req.setAttribute("lessons", allLessons);
        req.getRequestDispatcher("/lessons.jsp").forward(req, resp);

    }
}
