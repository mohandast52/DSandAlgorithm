package competitveProgramming;

import java.util.Arrays;

public class Main {
    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4, 5};
        int sum = 5;
        System.out.println(recursiveCountCoins(arr, sum, arr.length));
        System.out.println(dpCoinChange(arr, sum, arr.length));
    }

    private static int dpCoinChange(int[] arr, int sum, int length) {
        int hash[][] = new int[length + 1][length + 1];
        // first row
        for (int i = 0; i < hash.length; i++) {
            hash[i][0] = 0;
        }
        hash[0][0] = 1;
        for (int i = 1; i < hash.length; i++) {
            for (int j = 0; j < hash.length; j++) {
                if (i > j) {
                    hash[i][j] = hash[i - 1][j];
                } else {
                    hash[i][j] = hash[i - 1][j] + hash[i][j - 1];
                }
            }
            System.out.println(Arrays.toString(hash[i]));
        }
        return hash[length][length];
    }


    private static int recursiveCountCoins(int[] arr, int sum, int length) {


        if (sum == 0) {
            return 1;
        }

        if (sum < 0)
            return 0;

        /* means there is only one item! so it is always one */
        if (length == 1) {
            return 1;
        }

        return recursiveCountCoins(arr, sum, length - 1) +
                recursiveCountCoins(arr, sum - arr[length - 1], length);
    }
}
