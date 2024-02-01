package ru.rickh.service;

import lombok.Data;
import ru.rickh.model.Student;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
public class StudentService {
    List<Student> students;

    public StudentService(List<Student> students) {
        this.students = students;
    }
    
    public void add(String studentName) {
        students.add(new Student(studentName));
    }
    
    public boolean delete(String studentName) {
        return students.removeIf(a->studentName.equals(a.getName()));
    }
    
    public Optional<Student> getStudent(String stringInput) {
        return students.stream().filter(a -> a.getName().equals(stringInput)).findFirst();
    }
    public String getStudentGrades(List<Integer> grades) {
        if (grades == null || grades.isEmpty()) {
            return "Нет оценок";
        }
        return grades.stream().map(Object::toString).collect(Collectors.joining(","));
    }
    
    
}
