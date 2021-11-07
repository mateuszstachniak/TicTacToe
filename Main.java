package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//Generate clean board
        String tictactoe = "         ";
        int a = tictactoe.length();
        char ch;
        char[] symbol = new char[9];
        if (a == 9) {
            for (int i = 0; i < a; i++) {
                ch = tictactoe.charAt(i);
                symbol[i] = ch;
            }
        } else {
            System.exit(0);
        }
//Print clean board
        System.out.println("---------");
        System.out.println("| " + symbol[0] + " " + symbol[1] + " " + symbol[2] + " |");
        System.out.println("| " + symbol[3] + " " + symbol[4] + " " + symbol[5] + " |");
        System.out.println("| " + symbol[6] + " " + symbol[7] + " " + symbol[8] + " |");
        System.out.println("---------");
//Start game
        boolean wrongInput = true;
        boolean wrongSymbolY = true;
        boolean wrongSymbolX = true;
        boolean xWins = false;
        boolean oWins = false;
        boolean draw = false;
        int moveCounter = 0;
        do {
            do {
                int y = 0;
                int x = 0;
                System.out.print("Enter the coordinates: ");
//Catch bad coordinates
                try {
                    y = Integer.parseInt(scanner.next());
                } catch (NumberFormatException e) {
                    wrongSymbolY = false;
                }
                try {
                    x = Integer.parseInt(scanner.next());
                } catch (NumberFormatException e) {
                    wrongSymbolX = false;
                }
                if (wrongSymbolY == false || wrongSymbolX == false) {
                    System.out.println("You should enter numbers!");
                    continue;
                }
                if (y < 1 || y > 3 || x < 1 || x > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
//Coordinates conversion to 1d array
                int x1 = 0;
                if (x >= 1 && x <= 3) {
                    if (y == 1) {
                        x1 = 0 + x - 1;
                    } else if (y == 2) {
                        x1 = 3 + x - 1;
                    } else if (y == 3) {
                        x1 = 6 + x - 1;
                    }
                }
//Saving player move
                if (symbol[x1] == 'X' || symbol[x1] == 'O') {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                } else {
                    if (moveCounter % 2 == 0) {
                        symbol[x1] = 'X';
                    } else {
                        symbol[x1] = 'O';
                    }
                    moveCounter++;
                    wrongInput = false;
                }
            } while (wrongInput);
            System.out.println("---------");
            System.out.println("| " + symbol[0] + " " + symbol[1] + " " + symbol[2] + " |");
            System.out.println("| " + symbol[3] + " " + symbol[4] + " " + symbol[5] + " |");
            System.out.println("| " + symbol[6] + " " + symbol[7] + " " + symbol[8] + " |");
            System.out.println("---------");
//Check X, 0
            for (int j = 1; j < symbol.length; ) {
                if (symbol[j - 1] == 'X' && symbol[j] == 'X' && symbol[j + 1] == 'X') {
                    xWins = true;
                } else if (symbol[j - 1] == 'O' && symbol[j] == 'O' && symbol[j + 1] == 'O') {
                    oWins = true;
                }
                j++;
                j++;
                j++;
            }
            for (int j = 0; j <= 2; j++) {
                if (symbol[j] == 'X' && symbol[j + 3] == 'X' && symbol[j + 6] == 'X') {
                    xWins = true;
                } else if (symbol[j] == 'O' && symbol[j + 3] == 'O' && symbol[j + 6] == 'O') {
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
            for (char occ : symbol) {
                if (occ == 'X') {
                    counterX++;
                } else if (occ == 'O') {
                    counterO++;
                }
            }
            if (counterX + counterO == 9 && xWins == false && oWins == false) {
                draw = true;
            }
//Result
            if (xWins == false && oWins == false && draw) {
                System.out.println("Draw");
                break;
            } else if (xWins && draw == false) {
                System.out.println("X wins");
                break;
            } else if (oWins && draw == false) {
                System.out.println("O wins");
                break;
            }
        } while (xWins == false || oWins == false || draw == false);
    }
}