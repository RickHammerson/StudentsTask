package ru.rickh.model.menu;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface Printable<T> {
    Map<Integer,String> enumAsMap();
    T[] enumValues();
}
