package DP;

import java.util.ArrayList;
import java.util.Arrays;

public class LCS {
    static String str1 = "abcd";
    static String str2 = "bd";
    static int[][] memoValue = new int[str1.length()][str2.length()];

    static int numberOfCallRecursion = 1;
    static int numberOfCallMemoization = 1;

    public static void main(String args[]) {

        System.out.println("Recursion : " + recursion(str1, str2, 0, 0));

        System.out.println("Number of function call : " + numberOfCallRecursion);
        for (int i = 0; i < memoValue.length; i++) {
            Arrays.fill(memoValue[i], -1);
        }
        System.out.println("Memoization : " + memoization(str1, str2, 0, 0));
        System.out.println("Number of function call : " + numberOfCallMemoization);
        // print memoization
        for (int i = 0; i < memoValue.length; i++) {
            System.out.println(Arrays.toString(memoValue[i]));
        }

        // DP

    }


    private static int recursion(String str1, String str2, int i, int j) {
        ++numberOfCallRecursion;
        // i || j pointer has crossed the string's length
        if (i == str1.length() || j == str2.length()) {
            return 0;
        }

        if (str1.charAt(i) == str2.charAt(j)) {
            return 1 + (recursion(str1, str2, i + 1, j + 1));
        }

        return Math.max(recursion(str1, str2, i, j + 1), recursion(str1, str2, i + 1, j));
    }

    // since the recursive call has overlapping subproblems
    // https://www.youtube.com/watch?v=sSno9rV8Rhg
    private static int memoization(String str1, String str2, int i, int j) {
        ++numberOfCallMemoization;
        if (i == str1.length() || j == str2.length()) {
            return 0;
        }

        // if the same state has already been computed and stored, RETURN stored value
        if (memoValue[i][j] != -1) {
            --numberOfCallMemoization;
            return memoValue[i][j];
        }

        if (str1.charAt(i) == str2.charAt(j)) {
            memoValue[i][j] = 1 + (memoization(str1, str2, i + 1, j + 1));
            return memoValue[i][j];
        }

        memoValue[i][j] = Math.max(memoization(str1, str2, i, j + 1), memoization(str1, str2, i + 1, j));
        return memoValue[i][j];
    }

    // for numbers array
    private static void DP(int[] arr1, int[] arr2) {

        int[][] lcs = new int[arr1.length + 1][arr2.length + 1];
        for (int i = 1; i <= arr1.length; i++) {
            for (int j = 1; j <= arr2.length; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    lcs[i][j] = 1 + lcs[i - 1][j - 1];
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }

        /*
        PRINT :

        System.out.println("\t   " + Arrays.toString(arr2));
        int k = -1;
        for (int i = 0; i < lcs.length; i++) {
            if (k < arr1.length && k >= 0) {
                System.out.print(arr1[k]);
            }
            k++;
            System.out.print("\t" + Arrays.toString(lcs[i]) + "\n");
        }
        */

        // tracking back!

        int row = arr1.length;
        int col = arr2.length;
        ArrayList<Integer> list = new ArrayList<>();
        while (row > 0 && col > 0) {
            // both have common element, go upwards diagonally
            if (arr1[row - 1] == arr2[col - 1]) {
                list.add(arr1[row - 1]);
                --row;
                --col;
            } else if (lcs[row][col] == lcs[row - 1][col]) {
                --row;
            } else if (lcs[row][col] == lcs[row][col - 1]) {
                --col;
            }
        }
        System.out.println(list);
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
