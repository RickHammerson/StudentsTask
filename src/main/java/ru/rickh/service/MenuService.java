package ru.rickh.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        PrintUtils.printText("Добро пожаловать.Выберите способ загрузки студентов");
        Menu<FileLoadCommandEnum> loadStudentsMenu = new Menu<>(FileLoadCommandEnum.LOAD_STUDENTS_FILE);
        PrintUtils.printEnumValues(loadStudentsMenu.getEnumValuesMap());
        int inputNumber = getIntInput(loadStudentsMenu.getExitNumber());
        FileLoadCommandEnum value = loadStudentsMenu.getEnumValueByOrdinal(inputNumber);
        
        try {
            switch (value) {
                case LOAD_STUDENTS_FILE:
                    PrintUtils.printText("Введите путь к файлу");
                    studentService = new StudentService(fileService.load(getStringInput()));
                    PrintUtils.printText("Успешно загружено");
                    break;
                case CREATE_NEW_STUDENTS_FILE:
                default:
                    PrintUtils.printText("Создаем новый файл со студентами");
                    new StudentService(fileService.create());
                    PrintUtils.printText("Новый файл со студентами успешно создан");
                    break;
            }
        } catch (RuntimeException e) {
            PrintUtils.printText("Введено неверное значение");
            loadStudentsFileMenu();
        } catch (IOException e) {
            PrintUtils.printText("Невозможно создать или открыть файл");
            loadStudentsFileMenu();
        }
    }
    
    private void studentsMenu() {
        
        Menu<StudentCommandEnum> studentGradesMenu = new Menu<>(StudentCommandEnum.ADD_STUDENT);
        PrintUtils.printEnumValues(studentGradesMenu.getEnumValuesMap());
        int inputNumber = getIntInput(studentGradesMenu.getExitNumber());
        if (inputNumber == studentGradesMenu.getExitNumber()) {
            PrintUtils.printText("Я хочу питсу");
            System.exit(0);
        }
        StudentCommandEnum value = studentGradesMenu.getEnumValueByOrdinal(inputNumber);
        try {
            switch (value) {
                case ADD_STUDENT:
                    PrintUtils.printText("Введите имя студента");
                    studentService.add(getStringInput());
                    fileService.save(studentService.getStudents());
                    break;
                case DELETE_STUDENT:
                    PrintUtils.printText("Введите имя студента");
                    studentService.delete(getStringInput());
                    fileService.save(studentService.getStudents());
                    break;
                case SHOW_ALL_STUDENTS_GRADES:
                    List<Student> students = studentService.getStudents();
                    for (Student student : students) {
                        PrintUtils.printText(String.format(
                            "Студент с именем %s. Имеет оценки %s",
                            student.getName(),
                            studentService.getStudentGrades(student.getGrades())
                        ));
                    }
                    break;
                case SHOW_STUDENT_GRADE:
                    PrintUtils.printText("Введите имя студента");
                    Optional<Student> optionalStudent = studentService.getStudent(getStringInput());
                    if (optionalStudent.isPresent()) {
                        Student student = optionalStudent.get();
                        PrintUtils.printText(String.format(
                            "Студент с именем %s. Имеет оценки %s",
                            student.getName(),
                            studentService.getStudentGrades(student.getGrades())
                        ));
                    } else {
                        PrintUtils.printText("Студента с таким именем нет");
                    }
                    break;
                case UPDATE_STUDENT_GRADE:
                    PrintUtils.printText("Введите имя студента");
                    Optional<Student> studentForGradeUpdate = studentService.getStudent(getStringInput());
                    if (studentForGradeUpdate.isPresent()) {
                        Student student = studentForGradeUpdate.get();
                        List<Integer> grades = student.getGrades();
                        Map<Integer, Integer> gradesMap = IntStream.range(0, grades.size())
                            .boxed()
                            .collect(Collectors.toMap(i -> i, grades::get));
                        PrintUtils.printGrades(gradesMap);
                        fileService.save(studentService.getStudents());
                    } else {
                        PrintUtils.printText("Студента с таким именем нет");
                    }
                    break;
            }
        } catch (InputError e) {
            PrintUtils.printText("Введено неверное значение");
        } catch (IOException e) {
            PrintUtils.printText("Невозможно сохранить студентов в файл");
        }
        studentsMenu();
    }
}
