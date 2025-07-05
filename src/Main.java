//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static int boardSize = 9;

    public static void main(String[] args) {
      int [][] sudokuGame = {
            {5, 0, 4, 0, 6, 3, 0, 0, 1},
            {0, 0, 0, 9, 0, 0, 0, 0, 7},
            {1, 0, 0, 7, 0, 0, 0, 3, 0},
            {0, 8, 6, 1, 0, 7, 0, 5, 0},
            {3, 5, 0, 0, 2, 0, 0, 7, 6},
            {0, 1, 0, 3, 0, 6, 9, 4, 0},
            {0, 4, 0, 0, 0, 2, 0, 0, 5},
            {8, 0, 0, 0, 0, 9, 0, 0, 0},
            {7, 0, 0, 6, 3, 0, 4, 0, 9},
      };

      if (playSudoku(sudokuGame)) {
          System.out.println("O jogo foi resolvido");
      } else {
          System.out.println("Não foi possível resolver o jogo");
      }

    }

    public static boolean isNumberInRow(int[][] sudokuGame, int row, int number) {
        for (int i = 0; i < boardSize; i++) {
            if (sudokuGame[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNumberInColumn(int[][] sudokuGame, int column, int number) {
        for (int i = 0; i < boardSize; i++) {
            if (sudokuGame[i][column] == number) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNumberInSquare(int[][] sudokuGame, int row, int column, int number) {
        int squareRow = row - row % 3;
        int squareColumn = column - column % 3;

        for (int i = squareRow; i < squareRow + 1; i++) {
            for (int j = squareColumn; j < squareColumn + 1; j++) {
                if (sudokuGame[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isPlaceEmpty(int[][] sudokuGame, int row, int column, int number) {
        return !isNumberInColumn(sudokuGame, column, number) &&
                !isNumberInRow(sudokuGame, row, number) &&
                !isNumberInSquare(sudokuGame, row, column, number);
    }

    public static boolean playSudoku(int[][] sudokuGame) {
        for (int row = 0; row < boardSize; row++) {
            for (int column = 0; column < boardSize; column ++) {
                if (sudokuGame[row][column] == 0) {
                    for (int number = 1; number <= boardSize; number++) {
                        if(isPlaceEmpty(sudokuGame, row, column, number)) {
                            sudokuGame[row][column] = number;

                            if (playSudoku(sudokuGame)) {
                                return true;
                            } else {
                                sudokuGame[row][column] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}