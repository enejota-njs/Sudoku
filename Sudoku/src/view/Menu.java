package view;

import java.util.Scanner;

public class Menu {
    public int openMenu() {
        System.out.println("|=========== SUDOKU ===========|");
        System.out.println("| [ 1 ] - Iniciar um novo jogo |");
        System.out.println("| [ 2 ] - Adicionar um número  |");
        System.out.println("| [ 3 ] - Remover um número    |");
        System.out.println("| [ 4 ] - Visualizar jogo      |");
        System.out.println("| [ 5 ] - Verificar status     |");
        System.out.println("| [ 6 ] - Limpar tabuleiro     |");
        System.out.println("| [ 7 ] - Finalizar jogo       |");
        System.out.println("|==============================|");

        return chooseOption();
    }

    public int chooseOption() {
        var input = new Scanner(System.in);
        var option = 0;

        do {
            System.out.print("\nEscolha uma opção: ");
            try {
                option = input.nextInt();
            } catch (Exception e) {
                System.out.println("\nValor inválido.");
                System.out.println("Tente novamente.");
                chooseOption();
            }
        } while (option < 1 && option > 7);

        return option;
    }
}
