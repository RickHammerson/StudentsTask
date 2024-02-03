package ru.rickh.model.commands.students;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import ru.rickh.model.Student;
import ru.rickh.model.menu.StudentCommandEnum;
import ru.rickh.service.FileService;
import ru.rickh.service.StudentService;
import ru.rickh.util.PrintUtils;

import static ru.rickh.model.menu.StudentCommandEnum.SHOW_ALL_STUDENTS_GRADES;
import static ru.rickh.model.menu.StudentCommandEnum.SHOW_STUDENT_GRADES;
import static ru.rickh.util.ScanUtils.getStringInput;

public class ShowStudentGrades implements StudentCommand<StudentCommandEnum> {
    @Override
    public void run(StudentService studentService,FileService fileService) throws IOException {
        PrintUtils.printText("Введите имя студента");
        Optional<Student> optionalStudent = studentService.getStudent(getStringInput());
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            PrintUtils.printText(String.format(
                "Студент с именем %s. Имеет оценки: %s",
                student.getName(),
                studentService.getStudentGrades(student.getGrades())
            ));
        } else {
            PrintUtils.printText("Студента с таким именем нет");
        }
    }
    
    @Override
    public StudentCommandEnum supportEnumType() {
        return SHOW_STUDENT_GRADES;
    }
}
