package DP;

import java.util.Arrays;

public class SubsetSum {
    private static int sum = 0;

    public static void main(String args[]) {
        int[] arr = {1, 2, 7, 5};
        sum = 8;
        recursive(arr, 0, 0, new int[arr.length]);
        System.out.println(dp(arr, sum));
    }

    // recursive solution!
    public static void recursive(int[] arr, int currSum, int index, int[] solution) {
        // time complexity : 2^n, space : arr.length (recursive stack call)
        if (currSum == sum) /* to print the selected integer! */ {
            System.out.print("Ans : ");
            for (int i = 0; i < solution.length; i++) {
                System.out.print(solution[i] == 1 ? arr[i] + " " : "");
            }
            System.out.println();
        } else if (arr.length == index) {
            return;
        } else {
            // selected the current element
            currSum += arr[index];
            solution[index] = 1;
            // System.out.println(currSum + " " + Arrays.toString(solution));
            recursive(arr, currSum, index + 1, solution);

            // not selected the current element
            currSum -= arr[index];
            solution[index] = 0;
            // System.out.println(currSum + " " + Arrays.toString(solution));
            recursive(arr, currSum, index + 1, solution);
        }
        return;
    }
    /*
     pseudo-polynomial time : if its running time is a polynomial in the numeric value of the input (the largest integer present in the input) — but not necessarily in the length of the input (the number of bits required to represent it), which is the case for polynomial time algorithms.
    */


    // https://www.youtube.com/watch?v=K20Tx8cdwYY (best explanation!)
    // https://www.youtube.com/watch?v=nqlNzOcnCfs
    public static boolean dp(int[] arr, int sum) {
        Arrays.sort(arr);
        boolean[][] solution = new boolean[arr.length + 1][sum + 1];
        solution[0][0] = true; // 0 can be made from 0

        // in first row, everything is set to false as 0 sum 1,2,.. cannot be created using 0!

        int arrSum = 0;
        for (int row = 1; row <= arr.length; row++) {
            arrSum += arr[row - 1]; // summing all the arr and check with sum
            System.out.println(arrSum);
            for (int column = 0; column <= sum; column++) {
                if (arrSum < column) {
                    solution[row][column] = false;
                } else {
                    // including the current value

                    // column value can be greater than array value, if we don't check we might check array with -ve index!
                    if (column >= arr[row - 1]) {
                        solution[row][column] = solution[row - 1][column - arr[row - 1]];
                    }

                    // excluding the current value, i.e pick from above row, same column
                    solution[row][column] = (solution[row][column] || solution[row - 1][column]);
                }
            }
        }
        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution[i].length; j++) {
                System.out.print((solution[i][j] + "\t"));
            }
            System.out.println();
        }

        for (int row = 1; row <= arr.length; row++) {
            if (solution[row][sum]) /* last column, first row */ {
                System.out.println(arr[row - 1]);
            }
        }
        return solution[arr.length][sum];
    }

}
