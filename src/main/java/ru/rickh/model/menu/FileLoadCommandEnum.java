package ru.rickh.model.menu;

import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
public enum FileLoadCommandEnum implements Printable<FileLoadCommandEnum> {
    LOAD_STUDENTS_FILE( "Загрузить из файла"),
    CREATE_NEW_STUDENTS_FILE( "Создать новый файл");

    private final String commandName;

    FileLoadCommandEnum(String commandString) {
        this.commandName = commandString;
    }

    @Override
    public Map<Integer,String> enumAsMap() {
        return Arrays.stream(FileLoadCommandEnum.values()).collect(Collectors.toMap(FileLoadCommandEnum::ordinal, FileLoadCommandEnum::getCommandName));
    }

    @Override
    public FileLoadCommandEnum[] enumValues() {
        return FileLoadCommandEnum.values();
    }
}
