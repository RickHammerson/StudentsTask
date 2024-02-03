package ru.rickh.model.commands.students;

import java.io.IOException;
import java.util.List;

import ru.rickh.model.Student;
import ru.rickh.model.menu.StudentCommandEnum;
import ru.rickh.service.FileService;
import ru.rickh.service.StudentService;
import ru.rickh.util.PrintUtils;

import static ru.rickh.model.menu.StudentCommandEnum.ADD_STUDENT;
import static ru.rickh.model.menu.StudentCommandEnum.SHOW_ALL_STUDENTS_GRADES;
import static ru.rickh.util.ScanUtils.getStringInput;

public class ShowAllStudentsGrades implements StudentCommand<StudentCommandEnum> {
    @Override
    public void run(StudentService studentService,FileService fileService) throws IOException {
        List<Student> students = studentService.getStudents();
        if (students.isEmpty()) {
            PrintUtils.printText("Нет студентов");
        }
        for (Student student : students) {
            PrintUtils.printText(String.format(
                "Студент с именем %s. Имеет оценки: %s",
                student.getName(),
                studentService.getStudentGrades(student.getGrades())
            ));
        }
    }
    
    @Override
    public StudentCommandEnum supportEnumType() {
        return SHOW_ALL_STUDENTS_GRADES;
    }
}
