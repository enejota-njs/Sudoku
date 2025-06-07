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
                List.of(1, 1, 6, true),
                List.of(1, 2, 3, false),
                List.of(1, 3, 1, false),
                List.of(1, 4, 5, false),
                List.of(1, 5, 4, false),
                List.of(1, 6, 9, false),
                List.of(1, 7, 8, true),
                List.of(1, 8, 7, true),
                List.of(1, 9, 2, true),
                List.of(2, 1, 2, false),
                List.of(2, 2, 7, true),
                List.of(2, 3, 5, true),
                List.of(2, 4, 8, false),
                List.of(2, 5, 3, false),
                List.of(2, 6, 1, true),
                List.of(2, 7, 6, true),
                List.of(2, 8, 9, false),
                List.of(2, 9, 4, false),
                List.of(3, 1, 9, false),
                List.of(3, 2, 4, false),
                List.of(3, 3, 8, false),
                List.of(3, 4, 6, false),
                List.of(3, 5, 7, false),
                List.of(3, 6, 2, true),
                List.of(3, 7, 5, false),
                List.of(3, 8, 1, false),
                List.of(3, 9, 3, true),
                List.of(4, 1, 8, false),
                List.of(4, 2, 2, true),
                List.of(4, 3, 3, false),
                List.of(4, 4, 1, false),
                List.of(4, 5, 5, true),
                List.of(4, 6, 7, false),
                List.of(4, 7, 4, false),
                List.of(4, 8, 6, false),
                List.of(4, 9, 9, true),
                List.of(5, 1, 7, false),
                List.of(5, 2, 5, false),
                List.of(5, 3, 4, true),
                List.of(5, 4, 3, true),
                List.of(5, 5, 9, false),
                List.of(5, 6, 6, true),
                List.of(5, 7, 2, false),
                List.of(5, 8, 8, false),
                List.of(5, 9, 1, true),
                List.of(6, 1, 1, false),
                List.of(6, 2, 6, true),
                List.of(6, 3, 9, true),
                List.of(6, 4, 2, false),
                List.of(6, 5, 8, false),
                List.of(6, 6, 4, true),
                List.of(6, 7, 7, false),
                List.of(6, 8, 3, false),
                List.of(6, 9, 5, true),
                List.of(7, 1, 5, false),
                List.of(7, 2, 1, false),
                List.of(7, 3, 6, false),
                List.of(7, 4, 9, true),
                List.of(7, 5, 2, false),
                List.of(7, 6, 8, false),
                List.of(7, 7, 3, false),
                List.of(7, 8, 4, false),
                List.of(7, 9, 7, false),
                List.of(8, 1, 4, true),
                List.of(8, 2, 9, false),
                List.of(8, 3, 2, true),
                List.of(8, 4, 7, true),
                List.of(8, 5, 6, false),
                List.of(8, 6, 3, false),
                List.of(8, 7, 1, true),
                List.of(8, 8, 5, false),
                List.of(8, 9, 8, true),
                List.of(9, 1, 3, false),
                List.of(9, 2, 8, false),
                List.of(9, 3, 7, false),
                List.of(9, 4, 4, true),
                List.of(9, 5, 1, false),
                List.of(9, 6, 5, false),
                List.of(9, 7, 9, false),
                List.of(9, 8, 2, true),
                List.of(9, 9, 6, true)
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
        return false;
    }

    public void addNumber() {
        if (!checkStatus()) {
            gameView.gameNotStartedMessage();
            return;
        }

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
        if (!checkStatus()) {
            gameView.gameNotStartedMessage();
            return;
        }

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
        if (!checkStatus()) {
            gameView.gameNotStartedMessage();
            return;
        }

        board.cleanBoard();
    }
}