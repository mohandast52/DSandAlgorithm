package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

// https://www.youtube.com/watch?v=FO7VXDfS8Gk

public class LargestSquareOf1s {
    public static void main(String args[]) throws Exception {
        PrintWriter out = new PrintWriter(System.out);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] _line_ = reader.readLine().trim().split("\\s+");
        int row = Integer.parseInt(_line_[0]);
        int col = Integer.parseInt(_line_[1]);

        int[][] arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            _line_ = reader.readLine().trim().split("\\s+");
            for (int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(_line_[j]);
            }
        }


        int max = 0;
        int[][] cache = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || j == 0) {
                    cache[i][j] = arr[i][j];
                } else if (arr[i][j] > 0) {
                    // ans[i][j] = MIN(top-left, top, left);
                    cache[i][j] = Math.min(Math.min(cache[i - 1][j], cache[i][j - 1]), cache[i - 1][j - 1]) + 1;
                }
                max = Math.max(cache[i][j], max);
            }
        }
        for (int i = 0; i < row; i++) {
            out.println(Arrays.toString(cache[i]));
        }
        out.println(max);
        out.flush();
    }
}
/*

4 5
1 1 0 1 0
0 1 1 1 0
1 1 1 1 0
0 1 1 1 1

*/