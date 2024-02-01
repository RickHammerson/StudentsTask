package ru.rickh.util;

import ru.rickh.model.menu.Printable;

import java.util.Map;

public class PrintUtils {
    final static char DELIMITER='-';
    final static char DELIMITER_BAR_SIZE=15;
    static String DELIMITER_BAR;

    static {
        fillDelimiterBar();
    }

    private static void fillDelimiterBar() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < DELIMITER_BAR_SIZE; i++) {
            sb.append(DELIMITER);
        }
        DELIMITER_BAR = sb.toString();
    }

    public static void printDelimiter() {
        System.out.println();
        System.out.println(DELIMITER_BAR);
        System.out.println();
    }
    
    public static void printEnumValues(Map<Integer, String> enumMap) {
        for ( Map.Entry<Integer, String> entry : enumMap.entrySet()) {
            System.out.printf("%d.%s%n", entry.getKey(), entry.getValue());
        }
    }
    
    public static void printGrades(Map<Integer, Integer> grades) {
        for ( Map.Entry<Integer, Integer> entry : grades.entrySet()) {
            System.out.printf("%d.%d%n", entry.getKey(), entry.getValue());
        }
    }
    
    public static void printExitCommand(int exitNumber) {
        System.out.printf("%d.Выход %n", exitNumber);
        PrintUtils.printDelimiter();
    }
    
    public static void printText(String text) {
        PrintUtils.printDelimiter();
        System.out.println(text);
        PrintUtils.printDelimiter();
    }
}
