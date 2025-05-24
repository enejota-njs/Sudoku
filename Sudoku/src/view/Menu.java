package view;

import java.util.Scanner;

public class Menu {
    public int openMenu() {
        System.out.println("\n|=========== SUDOKU ===========|");
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

        System.out.print("\nEscolha uma opção: ");
        try {
            option = input.nextInt();
            if (!(option >= 1 && option <= 7)) {
                invalidMessage();
                chooseOption();
            }
        } catch (Exception e) {
            invalidMessage();
            chooseOption();
        }

        return option;
    }

    public void invalidMessage() {
        System.out.println("\nValor inválido.");
        System.out.println("Tente novamente.");
    }
}
