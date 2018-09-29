package TimePass;

import java.util.Arrays;

public class ConcentricRectangularPattern {
    public static void main(String[] sp) throws Exception {
        int A = 6;
        int[][] arr = prettyPrint(A);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    public static int[][] prettyPrint(int A) {
        int[][] B = new int[A + A - 1][A + A - 1];
        for (int i = 0; i < A; i++) {
            int temp = A;
            int j = 0;
            for (; j <= i; j++) {
                B[i][j] = temp;
                temp -= 1;
            }

            ++temp; // because temp -= 1 will decrease it, so we have make it + 1;
            int last = B.length - i - 2;
            if (i < j) {
                for (; j <= last; j++) {
                    B[i][j] = temp;
                }
            }

            // now print from behind ie. 4, 3, 2
            temp = A;
            for (int k = B.length - 1; k >= j; k--) {
                B[i][k] = temp;
                temp -= 1;
            }
        }

        // row_1 == row_last, row_2 == row_2ndLast etc.
        int rowPtr = 0;
        for (int i = B.length - 1; i >= A; i--) {
            for (int j = 0; j < B.length; j++) {
                B[i][j] = B[rowPtr][j];
            }
            ++rowPtr;
        }

        return B;
    }
}
