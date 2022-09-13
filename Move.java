package tictactoe;

public class Move implements Invariables {

    int y;
    int x;
    boolean isNotNumber;
    boolean isNotValid;

    void setYX() {
        System.out.print("Enter the coordinates: (Y X; numbers 1-3)");
        try {
            this.y = Integer.parseInt(sc.next());
            this.x = Integer.parseInt(sc.next());
            this.isNotNumber = false;
            checkIfInRange(this.y, this.x);
        } catch (NumberFormatException e) {
            this.isNotNumber = true;
        }
    }

    private void checkIfInRange(int y, int x) {
        this.isNotValid = (y < 1) || (y > 3) || (x < 1) || (x > 3);
    }

    boolean isNotNumber() {
        return isNotNumber;
    }

    boolean isNotValid() {
        return isNotValid;
    }

    int convertTo1Dimensional() {
        if (this.x >= 1 && this.x <= 3) {
            if (this.y == 1) {
                return x - 1;
            } else if (this.y == 2) {
                return 3 + x - 1;
            } else if (this.y == 3) {
                return 6 + x - 1;
            }
        }
        return 0;
    }
}
