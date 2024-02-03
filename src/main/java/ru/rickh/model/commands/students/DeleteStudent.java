package ru.rickh.model.commands.students;

import java.io.IOException;

import ru.rickh.model.menu.StudentCommandEnum;
import ru.rickh.service.FileService;
import ru.rickh.service.StudentService;
import ru.rickh.util.PrintUtils;

import static ru.rickh.model.menu.StudentCommandEnum.ADD_STUDENT;
import static ru.rickh.model.menu.StudentCommandEnum.DELETE_STUDENT;
import static ru.rickh.util.ScanUtils.getStringInput;

public class DeleteStudent implements StudentCommand<StudentCommandEnum> {
    @Override
    public void run(StudentService studentService,FileService fileService) throws IOException {
        PrintUtils.printText("Введите имя студента");
        if (studentService.delete(getStringInput())) {
            fileService.save(studentService.getStudents());
        } else {
            PrintUtils.printText("Студент не найден");
        }
    }
    
    @Override
    public StudentCommandEnum supportEnumType() {
        return DELETE_STUDENT;
    }
}
