package ru.rickh.model;

import lombok.Getter;

@Getter
public enum Grade {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5);

    private final int numberRepresentation;

    Grade(int numberRepresentation) {
        this.numberRepresentation = numberRepresentation;
    }
}
