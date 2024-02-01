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
    
    public void delete(String studentName) {
        students.remove(studentName);
    }
    
    public Optional<Student> getStudent(String stringInput) {
        return students.stream().filter(a -> a.getName().equals(stringInput)).findFirst();
    }
    public String getStudentGrades(List<Integer> grades) {
        return grades.stream().map(Object::toString).collect(Collectors.joining(","));
    }
    
    
}
