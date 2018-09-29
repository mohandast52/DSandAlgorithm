package competitveProgramming;

public class Answers {
    public static void main(String[] args) {
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
        if (solve(board, N)) {
            // print solution
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    System.out.print(board[r][c] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Wrong Inputs");
        }
    }

    public static boolean solve(int[][] board, int N) {

        int row = -1;
        int col = -1;
        boolean isfree = true;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                // black index
                if (board[r][c] == 0) {
                    row = r;
                    col = c;
                    isfree = false;
                    break;
                }
            }
        }

        if (isfree) {
            return true;
        } else {
            for (int num = 1; num <= N; num++) {
                if (isSafe(board, N, row, col, num)) {
                    board[row][col] = num;
                    if (solve(board, N)) {
                        return true;
                    } else {
                        board[row][col] = 0;
                    }
                }
            }
        }
        return false;
    }

    public static boolean isSafe(int[][] board, int N, int row, int col, int numberToPlace) {

        // col-clash
        for (int r = 0; r < N; r++) {
            if (board[r][col] == numberToPlace) return false;
        }

        // row-clash
        for (int c = 0; c < N; c++) {
            if (board[row][c] == numberToPlace) return false;
        }

        // box check
        int sqrt = (int) Math.sqrt(N);
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;

        for (int r = rowStart; r < rowStart + sqrt; r++) {
            for (int c = colStart; c < colStart + sqrt; c++) {
                if (board[r][c] == numberToPlace) return false;
            }
        }

        return true;
    }

    /*
    {
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

    */

}

