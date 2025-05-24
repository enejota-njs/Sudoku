package main;

import controller.Board;
import controller.GameFuctions;
import view.Menu;

public class Main {
    static GameFuctions game = new GameFuctions();

    public static void main(String[] args) {
        var status = true;

        while (status){
            var menu = new Menu();
            var option = menu.openMenu();

            switch (option) {
                case 1 -> game.newGame();
                case 2 -> game.addNumber();
                case 3 -> game.removeNumber();
                case 4 -> game.displayBoard();
                case 5 -> game.checkStatus();
                case 6 -> game.cleanBoard();
                case 7 -> status = false;
            }
        }

        System.out.println("\nJogo finalizado.");
    }
}
