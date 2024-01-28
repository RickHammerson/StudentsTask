package ru.rickh.model.menu;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
public enum CommandsEnum implements Printable {
    ADD_STUDENT(1,"Добавить студента"),
    DELETE_STUDENT(2,"Удалить студента"),
    UPDATE_STUDENT_GRADE(3,"Обновить оценку студента"),
    SHOW_ALL_STUDENTS_GRADES(4,"Показать все оценки всех студентов"),
    SHOW_STUDENT_GRADE(5,"Добавить студента");

    private final int commandNumber;
    private final String commandName;

    CommandsEnum(int commandNumber, String commandString) {
        this.commandNumber = commandNumber;
        this.commandName = commandString;
    }

    @Override
    public Map<Integer,String> enumAsMap() {
        return Arrays.stream(CommandsEnum.values()).collect(Collectors.toMap(CommandsEnum::getCommandNumber, CommandsEnum::getCommandName));
    }

    @Override
    public List<String> enumValues() {
        return Arrays.stream(CommandsEnum.values()).map(CommandsEnum::getCommandName).collect(Collectors.toList());
    }
}
