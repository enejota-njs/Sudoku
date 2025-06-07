package controller;

import model.Square;
import model.Status;
import view.GameView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static model.BoardTemplate.BOARD_TEMPLATE;

public class Board {
    private GameView gameView = new GameView();
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

    public void insertInitialValues(List<List<Object>> values) {
        startBoard();

        for (List<Object> value : values) {
            Integer row = (Integer) value.get(0);
            Integer column = (Integer) value.get(1);
            Integer expectedNumber = (Integer) value.get(2);
            Boolean isFixed = (Boolean) value.get(3);

            Integer currentNumber;
            if (isFixed) {
                currentNumber = expectedNumber;
            } else {
                currentNumber = null;
            }

            boardList.get(row-1).set(column-1, new Square(currentNumber, expectedNumber, isFixed));
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

        gameView.displayBoard(board);
    }

    public void addValue(Integer row, Integer column, Integer value) {
        if (boardList.get(row-1).get(column-1).isFixed()) {
            gameView.fixedPositionMessage();
        } else if ((boardList.get(row - 1).get(column - 1).getCurrentNumber() == null)){
            var square = boardList.get(row-1).get(column-1);
            square.setCurrentNumber(value);
            gameView.modifiedValueMessage();
        } else if ((boardList.get(row - 1).get(column - 1).getCurrentNumber().equals(value))){
            gameView.messageOfEqualValue();
        } else if ((boardList.get(row - 1).get(column - 1).getCurrentNumber() != null)){
            gameView.positionOccupiedMessage();
        } else {
            var square = boardList.get(row-1).get(column-1);
            square.setCurrentNumber(value);
            gameView.modifiedValueMessage();
        }
    }

    public void removeValue(Integer row, Integer column, Integer value) {
        if (boardList.get(row-1).get(column-1).isFixed()) {
            gameView.fixedPositionMessage();
        } else if ((boardList.get(row - 1).get(column - 1).getCurrentNumber() == null)){
            gameView.emptyPositionMessage();
        } else {
            var square = boardList.get(row-1).get(column-1);
            square.setCurrentNumber(value);
            gameView.modifiedValueMessage();
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

        gameView.cleanBoardMessage();
        incompleteStatus();
    }

    public boolean checkBoard() {
        for (int row = 0; row < boardList.size(); row++) {
            for (int col = 0; col < boardList.get(row).size(); col++) {
                if (boardList.get(row).get(col).getCurrentNumber() == null) {
                    incompleteStatus();
                    return false;
                } else if (boardList.get(row).get(col).getCurrentNumber() != boardList.get(row).get(col).getExpectedNumber()) {
                    incompleteStatus();
                    return false;
                }
            }
        }

        completeStatus();
        return true;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
