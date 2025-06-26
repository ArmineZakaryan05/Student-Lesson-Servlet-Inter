package org.example.studentlessonservletinter.service;

import org.example.studentlessonservletinter.db.DBConnectionProvider;
import org.example.studentlessonservletinter.model.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private Connection connection = DBConnectionProvider.getInstance().getConnection();
    private LessonService lessonService = new LessonService();


    public void add(Student student) {
        String sql = """
                INSERT INTO student(name,surname,email,age,lesson_id) VALUES('%s', '%s','%s',%d, %d)
                """.formatted(
                student.getName(),
                student.getSurname(),
                student.getEmail(),
                student.getAge(),
                student.getLesson().getId());
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int anInt = generatedKeys.getInt(1);
                student.setId(anInt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {
        String sql = "SELECT * FROM student";
        List<Student> result = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setEmail(resultSet.getString("email"));
                student.setAge(resultSet.getInt("age"));
                student.setLesson(lessonService.getLessonById(resultSet.getInt("lesson_id")));
                result.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Student getStudentById(int id) {
        String sql = "SELECT * FROM student WHERE id = " + id;
        List<Student> result = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setEmail(resultSet.getString("email"));
                student.setAge(resultSet.getInt("age"));
                student.setLesson(lessonService.getLessonById(resultSet.getInt("lesson_id")));
                result.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteStudent(int id) {
        String sql = "DELETE FROM student WHERE id = " + id;

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editStudent(Student student) {
        String sql = """
                Update student SET name='%s', surname='%s', email='%s', age=%d,lesson_id=%d
                """.formatted(student.getName(), student.getSurname(), student.getEmail(), student.getAge(), student.getLesson().getId());
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}