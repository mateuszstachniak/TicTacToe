package tictactoe;

public class Game extends Board implements Invariables {
    boolean wrongInput = true;
    boolean xWins = false;
    boolean oWins = false;
    boolean draw = false;
    int moveCounter = 0;

    void playGame() {
        setBoard();
        printBoard();

        do {
            createMove();
            checkBoardForWinner();
            checkForDraw();
        } while (giveResult());
    }

    void createMove() {
        do {
            Move move = new Move();
            move.setYX();
            if (move.isNotNumber()) {
                System.out.println("You should enter numbers!");
                continue;
            }
            if (move.isNotValid()) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }
            saveMoveOnBoard(move);
        } while (wrongInput);
        printBoard();
    }

    void saveMoveOnBoard(Move move) {
        if (board[move.convertTo1Dimensional()] == 'X' || board[move.convertTo1Dimensional()] == 'O') {
            System.out.println("This cell is occupied! Choose another one!");
        } else {
            if (moveCounter % 2 == 0) {
                board[move.convertTo1Dimensional()] = 'X';
            } else {
                board[move.convertTo1Dimensional()] = 'O';
            }
            moveCounter++;
            wrongInput = false;
        }
    }

    void checkBoardForWinner() {
        checkRows();
        checkColumns();
        checkDiagonal();
    }

    void checkRows() {
        for (int j = 1; j < board.length; j = j + 3) {
            if (board[j - 1] == 'X' && board[j] == 'X' && board[j + 1] == 'X') {
                xWins = true;
            } else if (board[j - 1] == 'O' && board[j] == 'O' && board[j + 1] == 'O') {
                oWins = true;
            }
        }
    }

    void checkColumns() {
        for (int j = 0; j <= 2; j++) {
            if (board[j] == 'X' && board[j + 3] == 'X' && board[j + 6] == 'X') {
                xWins = true;
            } else if (board[j] == 'O' && board[j + 3] == 'O' && board[j + 6] == 'O') {
                oWins = true;
            }
        }
    }

    void checkDiagonal() {
        if (board[0] == 'X' && board[4] == 'X' && board[8] == 'X') {
            xWins = true;
        } else if (board[0] == 'O' && board[4] == 'O' && board[8] == 'O') {
            oWins = true;
        } else if (board[2] == 'X' && board[4] == 'X' && board[6] == 'X') {
            xWins = true;
        } else if (board[2] == 'O' && board[4] == 'O' && board[6] == 'O') {
            oWins = true;
        }
    }

    void checkForDraw() {
        int counterX = 0;
        int counterO = 0;
        for (char field : board) {
            if (field == 'X') {
                counterX++;
            } else if (field == 'O') {
                counterO++;
            }
        }
        if (counterX + counterO == BOARD_SIZE && !xWins && !oWins) {
            draw = true;
        }
    }

    boolean giveResult() {
        if (!xWins && !oWins && draw) {
            System.out.println("Draw");
            return false;
        } else if (xWins && !draw) {
            System.out.println("X wins");
            return false;
        } else if (oWins && !draw) {
            System.out.println("O wins");
            return true;
        }
        return true;
    }

}
