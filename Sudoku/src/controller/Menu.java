package controller;

import view.MenuView;

import java.util.Scanner;

public class Menu {
    GameFunctions game = new GameFunctions();
    MenuView menuView = new MenuView();
    private final Scanner scanner = new Scanner(System.in);

    public void openMenu() {
        while (true){
            menuView.openMenu();

            int option = -1;
            try {
                menuView.chooseAnOption();
                option = scanner.nextInt();
                scanner.nextLine();

                if (!(option >= 0 && option <= 5)) {
                    menuView.invalidMessage();
                    openMenu();
                    return;
                }
            } catch (Exception e) {
                scanner.nextLine();
                menuView.invalidMessage();
                openMenu();
                return;
            }

            directFunction(option);
            if (option == 5) return;
            if (game.checkStatus()) {
                game.displayBoard();
            }
        }
    }

    public void directFunction(int option) {
        switch (option) {
            case 0 -> game.newGame();
            case 1 -> game.addNumber();
            case 2 -> game.removeNumber();
            case 3 -> game.getStatus();
            case 4 -> game.cleanBoard();
            case 5 -> menuView.gameOverMessage();
        }
    }
}
