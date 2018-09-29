package Backtracking;

public class RatInMaze {
    public static void main(String args[]) {

        int[][] board = new int[][]{
                {1, 0, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        int n = board.length;
        solveMaze(board, n);
    }

    public static void solveMaze(int[][] board, int n) {
        int[][] solution = new int[n][n];
        mazeHelp(board, n, solution, 0, 0);
    }

    public static void mazeHelp(int[][] board, int n, int[][] solution, int x, int y) {

        // we are at last index of matrix
        if (x == n - 1 && y == n - 1) {
            solution[x][y] = 1;
            print(solution, n);
            return;
        }

        if (x < 0 || y < 0 || x >= n || y >= n || board[x][y] == 0 || solution[x][y] == 1) {
            return;
            // board[x][y] => there is obstacle
            // solution[x][y] => already included, so don't include again
        }

        solution[x][y] = 1;

        // up
        mazeHelp(board, n, solution, x - 1, y);
        // right
        mazeHelp(board, n, solution, x, y + 1);
        // left
        mazeHelp(board, n, solution, x, y - 1);
        // down
        mazeHelp(board, n, solution, x + 1, y);

        solution[x][y] = 0;
    }

    public static void print(int[][] solution, int n) {
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                System.out.print(solution[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
