package view;

public class MenuView {
    public void openMenu() {
        System.out.println("\n|=========== SUDOKU ===========|");
        System.out.println("| [ 0 ] - Iniciar um novo jogo |");
        System.out.println("| [ 1 ] - Adicionar um número  |");
        System.out.println("| [ 2 ] - Remover um número    |");
        System.out.println("| [ 3 ] - Verificar status     |");
        System.out.println("| [ 4 ] - Limpar tabuleiro     |");
        System.out.println("| [ 5 ] - Finalizar jogo       |");
        System.out.println("|==============================|");
    }

    public void chooseAnOption() {
        System.out.print("\nEscolha uma opção: ");
    }

    public void invalidMessage() {
        System.out.println("\nValor inválido.");
        System.out.println("Tente novamente.");
    }

    public void gameOverMessage() {
        System.out.println("\nJogo finalizado.");
    }
}
