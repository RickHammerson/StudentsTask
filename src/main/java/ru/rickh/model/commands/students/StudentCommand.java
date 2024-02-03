package ru.rickh.model.commands.students;

import java.io.IOException;
import java.util.List;

import ru.rickh.model.Student;
import ru.rickh.model.menu.Printable;
import ru.rickh.service.FileService;
import ru.rickh.service.StudentService;

public interface StudentCommand<T extends Printable<T>>  {
     void run(StudentService studentService, FileService fileService) throws IOException ;
     T supportEnumType();

}
