package tictactoe;

import java.util.Arrays;

public class Board implements Invariables {
    char[] board;

    void setBoard() {
        this.board = new char[BOARD_SIZE];
        Arrays.fill(this.board, EMPTY);
    }

    void printBoard() {
        printLine();
        printBoardRow(0);
        printBoardRow(1);
        printBoardRow(2);
        printLine();
    }

    private void printLine() {
        System.out.println(LINE);
    }

    private void printBoardRow(int line) {
        System.out.printf("%s%c %c %c%s%n", LEFT_EDGE, this.board[line * 3], this.board[line * 3 + 1], this.board[line * 3 + 2], RIGHT_EDGE);
    }
}
