package ru.rickh.util;

import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

import ru.rickh.exception.InputError;

public class ScanUtils {
    static Scanner scanner = new Scanner(System.in);
    public static int getIntInput(int min,int max) {
        System.out.println();
        if (!scanner.hasNextInt()) {
            throw new InputError("Введено неверное значение");
        }
        int value = scanner.nextInt();
        if (value<min || value>max) {
            throw new InputError("Введено неверное значение");
        }
        return value;
    }
    
    public static String getStringInput() {
        System.out.println();
        if (!scanner.hasNextLine()) {
            throw new InputError("Введено неверное значение");
        }
        String next = scanner.next();
        if (StringUtils.isEmpty(next)) {
            throw new InputError("Введено неверное значение");
        }
        return next;
    }
}
