package model;

public class Square {
    private Integer currentNumber;
    private Integer expectedNumber;
    private boolean isFixed;

    public Square() {
    }

    public Square(Integer currentNumber, Integer expectedNumber, boolean isFixed) {
        this.currentNumber = currentNumber;
        this.expectedNumber = expectedNumber;
        this.isFixed = isFixed;
    }
}