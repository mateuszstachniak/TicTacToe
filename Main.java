package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");
        String tictactoe = scanner.nextLine();
        int a = tictactoe.length();
        char ch;
        char[] symbol = new char[9];
        if (a == 9) {
            for (int i = 0; i < a; i++) {
                ch = tictactoe.charAt(i);
                symbol[i] = ch;
            }
            System.out.println("---------");
            System.out.println("| " + symbol[0] + " " + symbol[1] + " " + symbol[2] + " |");
            System.out.println("| " + symbol[3] + " " + symbol[4] + " " + symbol[5] + " |");
            System.out.println("| " + symbol[6] + " " + symbol[7] + " " + symbol[8] + " |");
            System.out.println("---------");
        } else {
            System.exit(0);
        }
        boolean xWins = false;
        boolean oWins = false;
        boolean draw = false;
        boolean impossible = false;
//Check X, 0
        for (int i = 1; i < symbol.length; ) {
            if (symbol[i - 1] == 'X' && symbol[i] == 'X' && symbol[i + 1] == 'X') {
                xWins = true;
            } else if (symbol[i - 1] == 'O' && symbol[i] == 'O' && symbol[i + 1] == 'O') {
                oWins = true;
            }
            i++;
            i++;
            i++;
        }
        for (int i = 0; i <= 2; i++) {
            if (symbol[i] == 'X' && symbol[i + 3] == 'X' && symbol[i + 6] == 'X') {
                xWins = true;
            } else if (symbol[i] == 'O' && symbol[i + 3] == 'O' && symbol[i + 6] == 'O') {
                oWins = true;
            }
        }
        if (symbol[0] == 'X' && symbol[4] == 'X' && symbol[8] == 'X') {
            xWins = true;
        } else if (symbol[0] == 'O' && symbol[4] == 'O' && symbol[8] == 'O') {
            oWins = true;
        } else if (symbol[2] == 'X' && symbol[4] == 'X' && symbol[6] == 'X') {
            xWins = true;
        } else if (symbol[2] == 'O' && symbol[4] == 'O' && symbol[6] == 'O') {
            oWins = true;
        }
//Counter
        int counterX = 0;
        int counterO = 0;
        int counterSpace = 0;
        for (char occ : symbol) {
            if (occ == 'X') {
                counterX++;
            } else if (occ == 'O') {
                counterO++;
            } else if (occ == '_' || occ == ' ') {
                counterSpace++;
            }
        }
        if (counterX + counterO == 9 && xWins == false && oWins == false) {
            draw = true;
        }
        if (Math.abs(counterX - counterO) > 1 || (xWins && oWins)) {
            impossible = true;
        }
//Result
        if (xWins == false && oWins == false && draw) {
            System.out.println("Draw");
        } else if (xWins && draw == false && impossible == false) {
            System.out.println("X wins");
        } else if (oWins && draw == false && impossible == false) {
            System.out.println("O wins");
        } else if (impossible) {
            System.out.println("Impossible");
        } else {
            System.out.println("Game not finished");
        }
    }
}