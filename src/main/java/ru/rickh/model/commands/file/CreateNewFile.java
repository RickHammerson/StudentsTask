package ru.rickh.model.commands.file;

import java.io.IOException;
import java.util.List;

import ru.rickh.model.Student;
import ru.rickh.model.menu.FileLoadCommandEnum;
import ru.rickh.service.FileService;
import ru.rickh.util.PrintUtils;

import static ru.rickh.model.menu.FileLoadCommandEnum.LOAD_STUDENTS_FILE;
import static ru.rickh.util.ScanUtils.getStringInput;

public class CreateNewFile implements FileCommand<FileLoadCommandEnum> {
    @Override
    public List<Student> run(FileService fileService) throws IOException {
        PrintUtils.printText("Введите путь к файлу");
        return fileService.load(getStringInput());
    }
    
    @Override
    public FileLoadCommandEnum supportEnumType() {
        return LOAD_STUDENTS_FILE;
    }
}
