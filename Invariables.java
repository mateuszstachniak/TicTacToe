package tictactoe;

import java.util.Scanner;

public interface Invariables {
    Scanner sc = new Scanner(System.in);
    char EMPTY = ' ';
    int BOARD_SIZE = 9;
    String LINE = "---------";
    String LEFT_EDGE = "| ";
    String RIGHT_EDGE = " |";
}
