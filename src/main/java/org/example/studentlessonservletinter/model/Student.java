package org.example.studentlessonservletinter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    private int id;
    private String name;
    private String surname;
    private String email;
    private int age;
    private Lesson lesson;
}