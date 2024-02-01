package ru.rickh.model;

import java.util.Map;

import lombok.Data;
import ru.rickh.model.menu.Printable;

@Data
public class Menu<T> {
    private int exitNumber;
    private Map<Integer,String> enumValuesMap;
    private Printable<T> menuEnum;
    
    public Menu(Printable<T> menuEnum) {
        this.menuEnum = menuEnum;
        this.enumValuesMap = menuEnum.enumAsMap();
        this.exitNumber = enumValuesMap.size();
    }
    
    public T[] getEnumValues() {
        return menuEnum.enumValues();
    }
    
    public T getEnumValueByOrdinal(int number) {
        return getEnumValues()[number];
    }
    
}
