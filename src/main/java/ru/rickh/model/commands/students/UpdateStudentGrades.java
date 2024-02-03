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

import static ru.rickh.model.menu.StudentCommandEnum.SHOW_STUDENT_GRADES;
import static ru.rickh.model.menu.StudentCommandEnum.UPDATE_STUDENT_GRADE;
import static ru.rickh.util.ScanUtils.getIntInput;
import static ru.rickh.util.ScanUtils.getStringInput;

public class UpdateStudentGrades implements StudentCommand<StudentCommandEnum> {
    @Override
    public void run(StudentService studentService,FileService fileService) throws IOException {
        PrintUtils.printText("Введите имя студента");
        Optional<Student> studentForGradeUpdate = studentService.getStudent(getStringInput());
        if (studentForGradeUpdate.isPresent()) {
            Student student = studentForGradeUpdate.get();
            List<Integer> grades = student.getGrades();
            Map<Integer, Integer> gradesMap = IntStream.range(0, grades.size())
                .boxed()
                .collect(Collectors.toMap(i -> i, grades::get));
            PrintUtils.printGrades(gradesMap);
            PrintUtils.printText("Введите номер оценки студента на изменение");
            int gradeIndex = getIntInput(0,gradesMap.size());
            PrintUtils.printText("Введите оценку");
            int grade = getIntInput(2,5);
            grades.set(gradeIndex, grade);
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
