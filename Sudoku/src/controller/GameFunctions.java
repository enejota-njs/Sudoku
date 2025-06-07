package controller;

import view.GameView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameFunctions {
    private final Scanner scanner = new Scanner(System.in);
    private Board board = new Board();
    private final GameView gameView = new GameView();
    private static boolean gameStarted = false;

    public void newGame() {
        gameStarted = true;

        board.insertInitialValues(new ArrayList<>(List.of(
                List.of(1, 1, 0, 1, false), List.of(1, 2, 2, 2, true), List.of(1, 3, 3, 3, true), List.of(1, 4, 4, 4, true), List.of(1, 5, 5, 5, true),
                List.of(1, 6, 6, 6, true), List.of(1, 7, 7, 7, true), List.of(1, 8, 8, 8, true), List.of(1, 9, 9, 9, true),
                List.of(2, 1, 2, 2, true), List.of(2, 2, 3, 3, true), List.of(2, 3, 4, 4, true), List.of(2, 4, 5, 5, true), List.of(2, 5, 6, 6, true),
                List.of(2, 6, 7, 7, true), List.of(2, 7, 8, 8, true), List.of(2, 8, 9, 9, true), List.of(2, 9, 1, 1, true),
                List.of(3, 1, 3, 3, true), List.of(3, 2, 4, 4, true), List.of(3, 3, 5, 5, true), List.of(3, 4, 6, 6, true), List.of(3, 5, 7, 7, true),
                List.of(3, 6, 8, 8, true), List.of(3, 7, 9, 9, true), List.of(3, 8, 1, 1, true), List.of(3, 9, 2, 2, true),
                List.of(4, 1, 4, 4, true), List.of(4, 2, 5, 5, true), List.of(4, 3, 6, 6, true), List.of(4, 4, 7, 7, true), List.of(4, 5, 8, 8, true),
                List.of(4, 6, 9, 9, true), List.of(4, 7, 1, 1, true), List.of(4, 8, 2, 2, true), List.of(4, 9, 3, 3, true),
                List.of(5, 1, 5, 5, true), List.of(5, 2, 6, 6, true), List.of(5, 3, 7, 7, true), List.of(5, 4, 8, 8, true), List.of(5, 5, 9, 9, true),
                List.of(5, 6, 1, 1, true), List.of(5, 7, 2, 2, true), List.of(5, 8, 3, 3, true), List.of(5, 9, 4, 4, true),
                List.of(6, 1, 6, 6, true), List.of(6, 2, 7, 7, true), List.of(6, 3, 8, 8, true), List.of(6, 4, 9, 9, true), List.of(6, 5, 1, 1, true),
                List.of(6, 6, 2, 2, true), List.of(6, 7, 3, 3, true), List.of(6, 8, 4, 4, true), List.of(6, 9, 5, 5, true),
                List.of(7, 1, 7, 7, true), List.of(7, 2, 8, 8, true), List.of(7, 3, 9, 9, true), List.of(7, 4, 1, 1, true), List.of(7, 5, 2, 2, true),
                List.of(7, 6, 3, 3, true), List.of(7, 7, 4, 4, true), List.of(7, 8, 5, 5, true), List.of(7, 9, 6, 6, true),
                List.of(8, 1, 8, 8, true), List.of(8, 2, 9, 9, true), List.of(8, 3, 1, 1, true), List.of(8, 4, 2, 2, true), List.of(8, 5, 3, 3, true),
                List.of(8, 6, 4, 4, true), List.of(8, 7, 5, 5, true), List.of(8, 8, 6, 6, true), List.of(8, 9, 7, 7, true),
                List.of(9, 1, 9, 9, true), List.of(9, 2, 1, 1, true), List.of(9, 3, 2, 2, true), List.of(9, 4, 3, 3, true), List.of(9, 5, 4, 4, true),
                List.of(9, 6, 5, 5, true), List.of(9, 7, 6, 6, true), List.of(9, 8, 7, 7, true), List.of(9, 9, 8, 8, true)
        )));

        gameView.gameStartedMessage();
        board.incompleteStatus();
        checkGame();
    }

    public boolean checkGame() {
        if (board.checkBoard()) {
            gameView.victoryMessage();
            return true;
        }
        return false;
    }

    public boolean checkStatus() {
        if (gameStarted) {
            return true;
        }
        gameView.gameNotStartedMessage();
        return false;
    }

    public void addNumber() {
        if (!checkStatus()) return;

        gameView.newValueMessage();
        String values = scanner.nextLine().trim();

        if (values.isEmpty()) {
            gameView.emptyValueMessage();
            return;
        }

        if (values.matches("\\d+") && (values.length() == 3)) {
            try {
                int row = Integer.parseInt(String.valueOf(values.charAt(0)));
                int column = Integer.parseInt(String.valueOf(values.charAt(1)));
                int number = Integer.parseInt(String.valueOf(values.charAt(2)));

                if ((row >= 1 && row <= 9) && (column >= 1 && column <= 9) && (number >= 1 && number <= 9)) {
                    board.addValue(row, column, number);
                } else {
                    gameView.wrongNumbersMessage();
                }
            } catch (Exception e) {
                gameView.invalidCharacterMessage();
            }
        } else {
            gameView.invalidCharacterMessage();
        }

        checkGame();
    }

    public void removeNumber() {
        if (!checkStatus()) return;

        gameView.valueRemovalMessage();
        String values = scanner.nextLine().trim();

        if (values.isEmpty()) {
            gameView.emptyValueMessage();
            return;
        }

        if (values.matches("\\d+") && (values.length() ==  2))  {
            try {
                int row = Integer.parseInt(String.valueOf(values.charAt(0)));
                int column = Integer.parseInt(String.valueOf(values.charAt(1)));

                if ((row >= 1 && row <= 9) && (column >= 1 && column <= 9)) {
                    board.removeValue(row, column, null);
                } else {
                    gameView.wrongNumbersMessage();
                }
            } catch (Exception e) {
                gameView.invalidCharacterMessage();
            }
        } else {
            gameView.invalidCharacterMessage();
        }

        checkGame();
    }

    public void displayBoard() {
        if (!checkStatus()) return;

        board.displayBoard();
    }

    public void getStatus() {
        switch (board.getStatus()) {
            case NOT_STARTED -> gameView.statusNotStarted();
            case INCOMPLETE -> gameView.statusIncomplete();
            case COMPLETE -> gameView.statusComplete();
        }
    }

    public void cleanBoard() {
        if (!checkStatus()) return;

        board.cleanBoard();
    }
}