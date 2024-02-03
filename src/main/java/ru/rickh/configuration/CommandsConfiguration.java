package ru.rickh.configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import ru.rickh.model.commands.file.CreateNewFile;
import ru.rickh.model.commands.file.FileCommand;
import ru.rickh.model.commands.file.LoadFromFile;
import ru.rickh.model.commands.students.AddNewStudent;
import ru.rickh.model.commands.students.AddStudentGrade;
import ru.rickh.model.commands.students.DeleteStudent;
import ru.rickh.model.commands.students.ShowAllStudentsGrades;
import ru.rickh.model.commands.students.ShowStudentGrades;
import ru.rickh.model.commands.students.StudentCommand;
import ru.rickh.model.commands.students.UpdateStudentGrades;
import ru.rickh.model.menu.FileLoadCommandEnum;
import ru.rickh.model.menu.StudentCommandEnum;

public class CommandsConfiguration {
    static List<FileCommand<FileLoadCommandEnum>> fileLoadCommands = Arrays.asList(new LoadFromFile(), new CreateNewFile());
    static List<StudentCommand<StudentCommandEnum>> studentCommands = Arrays.asList(
        new AddNewStudent(),
        new DeleteStudent(),
        new ShowStudentGrades(),
        new ShowAllStudentsGrades(),
        new UpdateStudentGrades(),
        new AddStudentGrade()
        );
    
    public static Map<FileLoadCommandEnum,FileCommand<FileLoadCommandEnum>> getFileCommandsMap() {
        Map<FileLoadCommandEnum, FileCommand<FileLoadCommandEnum>> commands = fileLoadCommands.stream()
            .collect(Collectors.toMap(FileCommand::supportEnumType, a->a));
        if (FileLoadCommandEnum.values().length != commands.size()) {
            throw new IllegalStateException("Несоответствие количества имплементаций команд");
        }
        return commands;
    }
    
    public static Map<StudentCommandEnum,StudentCommand<StudentCommandEnum>> getStudentCommandsMap() {
        Map<StudentCommandEnum, StudentCommand<StudentCommandEnum>> commands = studentCommands.stream()
            .collect(Collectors.toMap(StudentCommand::supportEnumType, a->a));
        if (StudentCommandEnum.values().length != commands.size()) {
            throw new IllegalStateException("Несоответствие количества имплементаций команд");
        }
        return commands;
    }
}
