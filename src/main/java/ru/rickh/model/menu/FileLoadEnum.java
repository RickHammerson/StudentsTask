package ru.rickh.model.menu;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
public enum FileLoadEnum implements Printable {
    LOAD_STUDENT(1,"Загрузить из файла"),
    CREATE_NEW_FILE(2,"Создать новых");

    private final int commandNumber;
    private final String commandName;

    FileLoadEnum(int commandNumber, String commandString) {
        this.commandNumber = commandNumber;
        this.commandName = commandString;
    }

    @Override
    public Map<Integer,String> enumAsMap() {
        return Arrays.stream(FileLoadEnum.values()).collect(Collectors.toMap(FileLoadEnum::getCommandNumber, FileLoadEnum::getCommandName));
    }

    @Override
    public List<String> enumValues() {
        return Arrays.stream(FileLoadEnum.values()).map(FileLoadEnum::getCommandName).collect(Collectors.toList());
    }
}
