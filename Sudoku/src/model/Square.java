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

    public Integer getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(Integer currentNumber) {
        this.currentNumber = currentNumber;
    }

    public Integer getExpectedNumber() {
        return expectedNumber;
    }

    public void setExpectedNumber(Integer expectedNumber) {
        this.expectedNumber = expectedNumber;
    }

    public boolean isFixed() {
        return isFixed;
    }

    public void setFixed(boolean fixed) {
        isFixed = fixed;
    }
}
