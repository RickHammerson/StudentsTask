package ru.rickh.util;

import java.util.Scanner;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import lombok.val;
import ru.rickh.exception.InputError;
import ru.rickh.model.menu.Printable;

public class ScanUtils {
    static Scanner scanner = new Scanner(System.in);
    public static int getIntInput(int limit) {
       
        if (!scanner.hasNextInt()) {
            throw new InputError("Введено неверное значение");
        }
        int value = scanner.nextInt();
        if (value>limit) {
            throw new InputError("Введено неверное значение");
        }
        return value;
    }
    
    public static String getStringInput() {
        if (!scanner.hasNextLine()) {
            throw new InputError("Введено неверное значение");
        }
        return scanner.next();
    }
    
    public static int getExitNumber(Printable printable) {
        return printable.enumAsMap().size();
    }
}
