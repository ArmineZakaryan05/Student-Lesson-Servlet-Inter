package org.example.studentlessonservletinter.service;

import org.example.studentlessonservletinter.db.DBConnectionProvider;
import org.example.studentlessonservletinter.model.Lesson;
import org.example.studentlessonservletinter.util.DateUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class LessonService {

    private Connection connection = DBConnectionProvider.getInstance().getConnection();

    public void add(Lesson lesson) {
        String sql = """
                INSERT INTO lesson (name, duration, lecturer_name, price) values ('%s','%s','%s',%f) 
                """.formatted(lesson.getName(), lesson.getDuration(), lesson.getLecturerName(), lesson.getPrice());
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                lesson.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Lesson> getAllLessons() {
        List<Lesson> result = new ArrayList<>();
        String sql = "SELECT * FROM lesson";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Lesson lesson = new Lesson();
                lesson.setId(resultSet.getInt("id"));
                lesson.setName(resultSet.getString("name"));
                lesson.setDuration(DateUtil.fromSqlStringToDate(resultSet.getString("duration")));
                lesson.setLecturerName(resultSet.getString("lecturer_name"));
                lesson.setPrice(resultSet.getDouble("price"));
                result.add(lesson);
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Lesson getLessonById(int id) {
        String sql = "SELECT * FROM lesson WHERE id =" + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                Lesson lesson = new Lesson();
                lesson.setId(resultSet.getInt("id"));
                lesson.setName(resultSet.getString("name"));
                lesson.setDuration(DateUtil.fromSqlStringToDate(resultSet.getString("duration")));
                lesson.setLecturerName(resultSet.getString("lecturer_name"));
                lesson.setPrice(resultSet.getDouble("price"));
                return lesson;
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteLesson(int id) {
        String sql = "DELETE FROM lesson WHERE id =" + id;
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editLesson(Lesson lesson) {
        String sql = """
                Update lesson SET name='%s', duration='%s', lecturer_name='%s', price='%s'
                """.formatted(lesson.getName(), lesson.getDuration(), lesson.getLecturerName(), lesson.getPrice());
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}