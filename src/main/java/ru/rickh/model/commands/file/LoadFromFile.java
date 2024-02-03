package ru.rickh.model.commands.file;

import java.io.IOException;
import java.util.List;

import ru.rickh.model.Student;
import ru.rickh.model.menu.FileLoadCommandEnum;
import ru.rickh.service.FileService;
import ru.rickh.util.PrintUtils;

import static ru.rickh.model.menu.FileLoadCommandEnum.CREATE_NEW_STUDENTS_FILE;

public class LoadFromFile implements FileCommand<FileLoadCommandEnum> {
    @Override
    public List<Student> run(FileService fileService) throws IOException {
        PrintUtils.printText("Создаем новый файл со студентами");
        return fileService.create();
    }
    
    @Override
    public FileLoadCommandEnum supportEnumType() {
        return CREATE_NEW_STUDENTS_FILE;
    }
}
