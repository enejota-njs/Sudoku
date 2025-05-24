package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameFuctions {
    private Board board = new Board();
    private Scanner scanner = new Scanner(System.in);

    private static boolean gameStatus = false;

    public void newGame() {
        gameStatus = true;

        board.insertFixedValues(new ArrayList<>(List.of("123", "334", "152", "781", "881", "882", "564", "459")));
        board.incompleteStatus();

        System.out.println("\nJogo iniciado.");
    }

    public void addNumber() {
        if (!checkGameStatus()) return;

        System.out.print("\nEscreva a linha, a coluna e o valor (sem espaços): ");
        String values = scanner.nextLine().trim();

        if (values.isEmpty()) {
            System.out.println("\nValor vazio.");
            return;
        }

        if (values.matches("\\d+") && (values.length() == 3)) {
            //try {
                int row = Integer.parseInt(String.valueOf(values.charAt(0)));
                int column = Integer.parseInt(String.valueOf(values.charAt(1)));
                int number = Integer.parseInt(String.valueOf(values.charAt(2)));

                if ((row >= 1 && row <= 9) && (column >= 1 && column <= 9) && (number >= 1 && number <= 9)) {
                    if (board.changeValue(row, column, number)) {
                        System.out.println("\nValor adicionado.");
                    } else {
                        System.out.println("\nValor já posicionado ou posição fixa.");
                    }
                } else {
                    System.out.println("\nEscreva apenas números entre 1 e 9.");
                }
            //} catch (Exception e) {
               // System.out.println("\nEscreva 3 números inteiros.");
              //  return;
            //}
        } else {
            System.out.println("\nEscreva 3 números inteiros.");
        }
    }

    public void removeNumber() {
        if (!checkGameStatus()) return;

        System.out.print("\nEscreva a linha e a coluna (sem espaços): ");
        String values = scanner.nextLine().trim();

        if (values.isEmpty()) {
            System.out.println("\nValor vazio.");
            return;
        }

        if (values.matches("\\d+") && (values.length() ==  2))  {
            try {
                int row = Integer.parseInt(String.valueOf(values.charAt(0)));
                int column = Integer.parseInt(String.valueOf(values.charAt(1)));

                if ((row >= 1 && row <= 9) && (column >= 1 && column <= 9)) {
                    if (board.changeValue(row, column, null)) {
                        System.out.println("\nValor removido.");
                    } else {
                        System.out.println("\nPosição fixa.");
                    }
                } else {
                    System.out.println("\nEscreva apenas números entre 1 e 9.");
                }
            } catch (Exception e) {
                System.out.println("\nEscreva 2 números inteiros.");
            }
        } else {
            System.out.println("\nEscreva 2 números inteiros.");
        }
    }

    public void displayBoard() {
        if (!checkGameStatus()) return;

        board.displayBoard();
    }

    public void checkStatus() {
        switch (board.getStatus()) {
            case NOT_STARTED -> System.out.println("\nStatus: Não iniciado.");
            case INCOMPLETE -> System.out.println("\nStatus: Incompleto.");
            case COMPLETE -> System.out.println("\nStatus: Completo.");
        }
    }

    public void cleanBoard() {
        if (!checkGameStatus()) return;

        board.cleanBoard();
    }

    public boolean checkGameStatus() {
        if (gameStatus) {
            return true;
        }

        System.out.println("\nJogo não iniciado.");
        return false;
    }
}
