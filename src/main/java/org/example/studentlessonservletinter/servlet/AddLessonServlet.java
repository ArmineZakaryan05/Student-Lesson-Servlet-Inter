package org.example.studentlessonservletinter.servlet;

import lombok.SneakyThrows;
import org.example.studentlessonservletinter.model.Lesson;
import org.example.studentlessonservletinter.service.LessonService;
import org.example.studentlessonservletinter.util.DateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addLesson")
public class AddLessonServlet extends HttpServlet {
    private LessonService lessonService = new LessonService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/addLesson.jsp").forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String duration = req.getParameter("duration");
        String lecturerName = req.getParameter("lecturerName");
        Double price = Double.parseDouble(req.getParameter("price"));

        Lesson lesson = Lesson.builder()
                .name(name)
                .duration(DateUtil.fromWebStringToDate(duration))
                .lecturerName(lecturerName)
                .price(price)
                .build();
        lessonService.add(lesson);
        resp.sendRedirect("/lessons");
    }
}