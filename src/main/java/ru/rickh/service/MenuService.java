package ru.rickh.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import ru.rickh.configuration.CommandsConfiguration;
import ru.rickh.exception.InputError;
import ru.rickh.model.Menu;
import ru.rickh.model.Student;
import ru.rickh.model.menu.FileLoadCommandEnum;
import ru.rickh.model.menu.StudentCommandEnum;
import ru.rickh.util.PrintUtils;

import static ru.rickh.util.ScanUtils.getIntInput;
import static ru.rickh.util.ScanUtils.getStringInput;

public class MenuService {
    StudentService studentService;
    FileService fileService = new FileService();
    
    public void run() {
        loadStudentsFileMenu();
        studentsMenu();
    }
    
    private void loadStudentsFileMenu() {
        PrintUtils.printText(
            "Добро пожаловать.Выберите способ загрузки студентов. " +
            "Вы не сможете продолжить,если не выберете один из вариантов");
        Menu<FileLoadCommandEnum> loadStudentsMenu = new Menu<>(FileLoadCommandEnum.LOAD_STUDENTS_FILE);
        PrintUtils.printEnumValues(loadStudentsMenu.getEnumValuesMap());
        int exitNumber = loadStudentsMenu.getExitNumber();
        PrintUtils.printExitCommand(exitNumber);
        try {
            int inputNumber = getIntInput(0,loadStudentsMenu.getExitNumber());
            if (inputNumber == exitNumber && studentService!=null) {
                return;
            }
            FileLoadCommandEnum value = loadStudentsMenu.getEnumValueByOrdinal(inputNumber);
            CommandsConfiguration.getFileCommandsMap().get(value).run(fileService);
        } catch (RuntimeException e) {
            PrintUtils.printText("Введено неверное значение");
        } catch (IOException e) {
            PrintUtils.printText("Невозможно создать или открыть файл");
        }
        loadStudentsFileMenu();
    }
    
    private void studentsMenu() {
        Menu<StudentCommandEnum> studentGradesMenu = new Menu<>(StudentCommandEnum.ADD_STUDENT);
        PrintUtils.printEnumValues(studentGradesMenu.getEnumValuesMap());
        int exitNumber = studentGradesMenu.getExitNumber();
        PrintUtils.printExitCommand(exitNumber);
        try {
            int inputNumber = getIntInput(0,exitNumber);
            if (inputNumber == exitNumber) {
                PrintUtils.printText("Я хочу питсу");
                System.exit(0);
            }
            StudentCommandEnum value = studentGradesMenu.getEnumValueByOrdinal(inputNumber);
            CommandsConfiguration.getStudentCommandsMap().get(value).run(studentService,fileService);
        } catch (InputError e) {
            PrintUtils.printText("Введено неверное значение");
        } catch (IOException e) {
            PrintUtils.printText("Невозможно сохранить студентов в файл");
        }
        studentsMenu();
    }
    
}
