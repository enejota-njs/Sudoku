package controller;

import model.Square;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Board {
    private boolean status;
    private static List<List<Square>> boardList = new ArrayList<>();

    public void startBoard() {
        boardList = IntStream.range(0, 9)
                .mapToObj(i -> IntStream.range(0, 9)
                        .mapToObj(j -> new Square())
                        .collect(Collectors.toCollection(ArrayList::new))
                )
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public void insertFixedValues(List<String> values) {
        for (var value : values) {
            var row = Integer.parseInt(String.valueOf(value.charAt(0)));
            var column = Integer.parseInt(String.valueOf(value.charAt(1)));
            var currentNumber = Integer.parseInt(String.valueOf(value.charAt(2)));
            var expectedNumber = Integer.parseInt(String.valueOf(value.charAt(3)));

            boardList.get(row).set(column, new Square(currentNumber, expectedNumber, true));
        }
    }

    public void displayBoard() {
        
    }
}
