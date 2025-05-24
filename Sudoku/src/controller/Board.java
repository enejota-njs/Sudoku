package controller;

import model.Square;
import model.Status;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static model.BoardTemplate.BOARD_TEMPLATE;

public class Board {
    private Status status = Status.NOT_STARTED;
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
        startBoard();

        for (var value : values) {
            var row = Integer.parseInt(String.valueOf(value.charAt(0)));
            var column = Integer.parseInt(String.valueOf(value.charAt(1)));
            var currentNumber = Integer.parseInt(String.valueOf(value.charAt(2)));

            boardList.get(row-1).set(column-1, new Square(currentNumber, currentNumber, true));
        }
    }

    public void displayBoard() {
        String board = String.format(BOARD_TEMPLATE,
                (Object[]) boardList.stream()
                        .flatMap(List::stream)
                        .map(sq -> {
                            Integer val = sq.getCurrentNumber();
                            return val == null ? " " : ""+val;
                        })
                        .toArray(String[]::new)
        );

        System.out.println(board);
    }

    public boolean changeValue(Integer row, Integer column, Integer value) {
        if (boardList.get(row-1).get(column-1).isFixed()) {
            return false;
        } else if (boardList.get(row - 1).get(column - 1).getCurrentNumber() == null) {
            var square = boardList.get(row-1).get(column-1);
            square.setCurrentNumber(value);
            return true;
        } else if ((boardList.get(row - 1).get(column - 1).getCurrentNumber().equals(value))){
            return false;
        } else {
            var square = boardList.get(row-1).get(column-1);
            square.setCurrentNumber(value);
            return true;
        }
    }

    public void incompleteStatus() {
        status = Status.INCOMPLETE;
    }

    public void completeStatus() {
        status = Status.COMPLETE;
    }

    public void cleanBoard() {
        for (List<Square> list : boardList) {
            for (Square square : list) {
                if (!(square.isFixed())) {
                    square.setCurrentNumber(null);
                }
            }
        }

        System.out.println("\nTabuleiro limpo.");
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
