package ru.rickh.model;

import lombok.Data;

import java.util.List;

@Data
public class Student {
    private String name;
    private List<Grade> grades;
}
