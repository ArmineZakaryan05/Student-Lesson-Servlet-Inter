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

@WebServlet("/editLesson")
public class EditLessonServlet extends HttpServlet {
    private LessonService lessonService = new LessonService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Lesson lesson = lessonService.getLessonById(id);
        req.setAttribute("lesson", lesson);
        req.getRequestDispatcher("/editLesson.jsp").forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String duration = req.getParameter("duration");
        String lecturerName = req.getParameter("lecturer_name");
        Double price = Double.parseDouble(req.getParameter("price"));

        Lesson lesson = Lesson.builder()
                .id(Integer.parseInt(id))
                .name(name)
                .duration(DateUtil.fromWebStringToDate(duration))
                .lecturerName(lecturerName)
                .price(price)
                .build();
        lessonService.editLesson(lesson);
        resp.sendRedirect("/lessons");
    }
}
