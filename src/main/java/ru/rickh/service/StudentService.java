package ru.rickh.service;

import ru.rickh.model.Student;

import java.util.List;

public class StudentService {

    List<Student> students;

    public StudentService(List<Student> students) {
        this.students = students;
    }


}
