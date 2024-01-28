package ru.rickh.model.menu;

import java.util.List;
import java.util.Map;

public interface Printable {
    Map<Integer,String> enumAsMap();
    List<String> enumValues();
    int getCommandNumber();
    int getCommandName();



}
