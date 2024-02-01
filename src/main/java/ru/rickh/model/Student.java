package ru.rickh.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Student {
    private String name;
    private List<Integer> grades;
    
    public Student() {
    }
    
    public Student(String name) {
        this.name = name;
    }
    
    public void addGrade(int grade) {
        if (grades == null) {
            grades = new ArrayList<>();
        }
        grades.add(grade);
    }
}
