package DP;

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

}
