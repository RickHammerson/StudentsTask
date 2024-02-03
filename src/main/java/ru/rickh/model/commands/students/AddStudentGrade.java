package ru.rickh.model.commands.students;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import ru.rickh.model.Student;
import ru.rickh.model.menu.StudentCommandEnum;
import ru.rickh.service.FileService;
import ru.rickh.service.StudentService;
import ru.rickh.util.PrintUtils;

import static ru.rickh.model.menu.StudentCommandEnum.UPDATE_STUDENT_GRADE;
import static ru.rickh.util.ScanUtils.getIntInput;
import static ru.rickh.util.ScanUtils.getStringInput;

public class AddStudentGrade implements StudentCommand<StudentCommandEnum> {
    @Override
    public void run(StudentService studentService,FileService fileService) throws IOException {
        PrintUtils.printText("Введите имя студента");
        Optional<Student> studentForGradeAdd = studentService.getStudent(getStringInput());
        if (studentForGradeAdd.isPresent()) {
            Student student = studentForGradeAdd.get();
            PrintUtils.printText("Введите оценку");
            int inputNumber = getIntInput(2,5);
            student.addGrade(inputNumber);
            fileService.save(studentService.getStudents());
        } else {
            PrintUtils.printText("Студента с таким именем нет");
        }
    }
    
    @Override
    public StudentCommandEnum supportEnumType() {
        return UPDATE_STUDENT_GRADE;
    }
}
