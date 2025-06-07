package view;

public class GameView {
    public void cleanBoardMessage() {
        System.out.println("\nTabuleiro limpo.");
    }

    public void displayBoard(String board) {
        System.out.println(board);
    }

    public void gameStartedMessage() {
        System.out.println("\nJogo iniciado.");
    }

    public void victoryMessage() {
        System.out.println("\nParabéns, você venceu! \uD83D\uDC4F");
    }

    public void gameNotStartedMessage() {
        System.out.println("\nJogo não iniciado.");
    }

    public void newValueMessage() {
        System.out.print("\nEscreva a linha, a coluna e o valor (sem espaços): ");
    }

    public void emptyValueMessage() {
        System.out.println("\nValor vazio.");
    }

    public void modifiedValueMessage() {
        System.out.println("\nValor modificado.");
    }

    public void fixedPositionMessage() {
        System.out.println("\nPosição fixa.");
    }

    public void messageOfEqualValue() {
        System.out.println("\nValor já posicionado.");
    }

    public void wrongNumbersMessage() {
        System.out.println("\nEscreva apenas números entre 1 e 9.");
    }

    public void invalidCharacterMessage() {
        System.out.println("\nEscreva 3 números inteiros.");
    }

    public void valueRemovalMessage() {
        System.out.print("\nEscreva a linha e a coluna (sem espaços): ");
    }

    public void statusNotStarted() {
        System.out.println("\nStatus: Não iniciado.");
    }

    public void statusIncomplete() {
        System.out.println("\nStatus: Incompleto.");
    }

    public void statusComplete() {
        System.out.println("\nStatus: Completo.");
    }

    public void positionOccupiedMessage() {
        System.out.println("\nPosição ocupada.");
    }

    public void emptyPositionMessage() {
        System.out.println("\nPosição vazia.");
    }
}