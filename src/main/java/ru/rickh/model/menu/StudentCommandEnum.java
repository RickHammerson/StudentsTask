package ru.rickh.model.menu;

import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
public enum StudentCommandEnum implements Printable<StudentCommandEnum> {
    ADD_STUDENT("Добавить студента"),
    DELETE_STUDENT("Удалить студента"),
    UPDATE_STUDENT_GRADE("Обновить оценку студента"),
    SHOW_ALL_STUDENTS_GRADES("Показать все оценки всех студентов"),
    SHOW_STUDENT_GRADE("Показать оценку студента");

    private final String commandName;

    StudentCommandEnum(String commandName) {
        this.commandName = commandName;
    }

    @Override
    public Map<Integer,String> enumAsMap() {
        return Arrays.stream(StudentCommandEnum.values()).collect(Collectors.toMap(StudentCommandEnum::ordinal, StudentCommandEnum::getCommandName));
    }

    @Override
    public StudentCommandEnum[] enumValues() {
        return StudentCommandEnum.values();
    }
}
