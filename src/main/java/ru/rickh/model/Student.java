package ru.rickh.model;

import lombok.Data;

import java.util.List;

@Data
public class Student {
    private String name;
    private List<Integer> grades;
    
    public Student(String name) {
        this.name = name;
    }
}
