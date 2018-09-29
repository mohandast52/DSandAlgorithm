package Backtracking;

public class Sudoku {
    public static void main(String args[]) {

        int[][] board = new int[][]{
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
        int N = board.length;

        //
        if (solveSudoku(board, N)) {
            // print solution
            print(board, N);
        } else {
            System.out.println("No solution");
        }
    }

    private static void tabSpace(int c, int N) {
        if ((c + 1) % (int) Math.sqrt(N) == 0) {
            System.out.print("\t");
        } else {
            System.out.print(" ");
        }
    }

    public static boolean isSafe(int[][] board, int row, int col, int num) {
        // row has the unique  (row-clash)
        for (int c = 0; c < board.length; c++) {
            // if the number we are trying to place is already present in that row, return false;
            if (board[row][c] == num) {
                return false;
            }
        }
        // column has the unique numbers (column-clash)
        for (int r = 0; r < board.length; r++) {
            // if the number we are trying to place is already present in that column, return false;
            if (board[r][col] == num) {
                return false;
            }
        }

        // corresponding square has unique number (box-clash)
        int sqrt = (int) Math.sqrt(board.length);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        for (int r = boxRowStart; r < boxRowStart + sqrt; r++) {
            for (int c = boxColStart; c < boxColStart + sqrt; c++) {
                if (board[r][c] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean solveSudoku(int[][] board, int n) {

        int row = -1;
        int col = -1;
        boolean isEmpty = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = true; // we still have some remaining missing values in Sudoku
                    break;
                }
            }
            if (isEmpty) {
                break;
            }
        }

        if (!isEmpty) {
            return true;
        }

        // else for each-row backtrack
        for (int num = 1; num <= n; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (solveSudoku(board, n)) {
                    // print(board, n);
                    return true;
                } else {
                    board[row][col] = 0; // replace it
                }
            }
        }

        return false;
    }

    public static void print(int[][] board, int N) {
        // we got the answer, just print it
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                System.out.print(board[r][c]);
                tabSpace(c, N);

            }
            System.out.println();
            if ((r + 1) % (int) Math.sqrt(N) == 0) {
                System.out.println();
            }
        }
    }
}
/*

Example 1:
{
    {1, 0, 2, 4},
    {0, 0, 3, 1},
    {3, 4, 0, 2},
    {0, 0, 4, 3}
};

Example 2:
{
    {1, 3, 0, 4},
    {2, 0, 3, 1},
    {0, 1, 0, 2},
    {4, 0, 1, 0}
}
*/