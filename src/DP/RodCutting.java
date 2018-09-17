package DP;

public class RodCutting {

    public static void main(String[] args) {
        int[] arr = {0, 1, 5, 8, 9};
        int sum = 4;
        System.out.println(rodCuttingRecursive(arr, 3));
        DP();
    }

    private static int rodCuttingRecursive(int[] arr, int n) {
        // System.out.println(n);
        if (n == 0)
            return arr[0];

        int maxSum = 0;
        for (int i = 1; i <= n; i++) {
            maxSum = Math.max(maxSum, arr[i] + rodCuttingRecursive(arr, n - i));
        }

        return maxSum;
    }

    private static void DP() {
        int arr[] = {2, 5, 9,6};
        int n = 5;
        int[][] solution = new int[arr.length + 1][n + 1];
        for (int row = 1; row <= arr.length; row++) {
            for (int col = 1; col <= n; col++) {
                int excludingCurrentRow = solution[row - 1][col];
                if (col < row) {
                    solution[row][col] = excludingCurrentRow;
                } else {
                    int remaining = col - row;
                    // System.out.println(row + " " + col + " " + remaining);
                    int includingCurrentRow = arr[row - 1] + solution[row][remaining];
                    solution[row][col] = Math.max(excludingCurrentRow, includingCurrentRow);
                }
            }
        }

        // print
        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution[i].length; j++) {
                System.out.print((solution[i][j] + "\t"));
            }
            System.out.println();
        }
    }
}
