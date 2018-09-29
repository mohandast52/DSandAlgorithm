package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class NQueens {
    // static int res[] = {0, 1, 0, 0, 2, 10, 4, 40, 92, 352, 724, 2680, 14200}; // first 12 solutions
    static int N = 6;
    final static int board[][] = new int[100][100];
    static PrintWriter out = new PrintWriter(System.out);
    static int solutionCount = 0;

    public static void main(String args[]) throws IOException {
        /*
            static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(reader.readLine());
        */
        solveNQueen(0);
        out.println(solutionCount);
        out.flush();
    }

    private static boolean solveNQueen(int row) {
        if (row == N) {
            /*
            * we have successfully placed all the n-rows, so return true;
            * means, it will come here only if all the n - 1 is placed!
            * even if one collides, there is no possibility is will come till 'n' i.e lastRow + 1
            * */
            ++solutionCount;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (board[r][c] == 1)
                        out.print("1 ");
                    else
                        out.print("0 ");
                }
                out.println();
            }

            out.println("");
            /*
            * return TRUE => when the 'lastRow + 1' is satisfied we return true;
            *
            * it clearly indicates that we can reach 'lastRow + 1', only if all the queens are placed,
            * so returning true will print one solution;
            *
            * return FALSE => it will print all possible solutions, because we have reached the end!
            * so we will print the solution and faking it that we haven't reached the solution, which will check
            * all the [rows][cols].
            *
            * */
            return false;
        }


        for (int col = 0; col < N; col++) {
            // checking for same row and different columns, whether the queen can be placed!
            if (isSafe(row, col)) {
                board[row][col] = 1; // assuming current position to be safe and checking if below queens can be placed

                boolean isPlaced = solveNQueen(row + 1); // next row

                // isPlaced return false, means the below queen can't be placed and remove the assumption.
                if (isPlaced) {
                    return true;
                } else {
                    board[row][col] = 0; // removing assumption; ie. backtracking
                }
            }
        }
        /*
        * we don't require to check below,because we haven't place anything below and we fill
        * from upper row to lower row
        * */
        return false; // we have tried for all positions in the current row but couldn't place the queen;
    }

    public static boolean isSafe(int row, int col) {
        // if colliding somewhere return false; else true;

        // 1. check for the upper columns (same line above)
        for (int r = 0; r < row; r++) {
            if (board[r][col] == 1)
                return false;
        }

        // 2. left diagonals
        int tempR = row;
        int tempC = col;
        while (tempR >= 0 && tempC >= 0) /* to remain inside board */ {
            if (board[tempR][tempC] == 1) {
                return false;
            }
            tempR--;
            tempC--;
        }

        // 3. right diagonals
        tempR = row;
        tempC = col;
        while (tempR >= 0 && tempC < N) /* to remain inside board */ {
            if (board[tempR][tempC] == 1) {
                return false;
            }
            tempR--;
            tempC++;
        }

        return true;
    }
}
