package ru.rickh.model.commands.file;

import java.io.IOException;
import java.util.List;

import ru.rickh.model.Student;
import ru.rickh.model.menu.Printable;
import ru.rickh.service.FileService;

public interface FileCommand<T extends Printable<T>>  {
     List<Student> run(FileService fileService) throws IOException;
     T supportEnumType();

}
