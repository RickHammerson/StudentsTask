package ru.rickh.model.commands.students;

import java.io.IOException;
import java.util.List;

import ru.rickh.model.Student;
import ru.rickh.model.menu.FileLoadCommandEnum;
import ru.rickh.model.menu.StudentCommandEnum;
import ru.rickh.service.FileService;
import ru.rickh.service.StudentService;
import ru.rickh.util.PrintUtils;

import static ru.rickh.model.menu.FileLoadCommandEnum.LOAD_STUDENTS_FILE;
import static ru.rickh.model.menu.StudentCommandEnum.ADD_STUDENT;
import static ru.rickh.util.ScanUtils.getStringInput;

public class AddNewStudent implements StudentCommand<StudentCommandEnum> {
    @Override
    public void run(StudentService studentService,FileService fileService) throws IOException {
        PrintUtils.printText("Введите имя студента");
        studentService.add(getStringInput());
        fileService.save(studentService.getStudents());
    }
    
    @Override
    public StudentCommandEnum supportEnumType() {
        return ADD_STUDENT;
    }
}
