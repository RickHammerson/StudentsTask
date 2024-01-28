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

    public static void printEnumValues(Printable enumToMap) {
        for (Map.Entry<Integer, String> entry : enumToMap.enumAsMap().entrySet()) {
            System.out.printf("%d.%s%n", entry.getKey(), entry.getValue());
        }
    }
}
