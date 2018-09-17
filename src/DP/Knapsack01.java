package DP;

import java.util.Arrays;

public class Knapsack01 {
    public static void main(String args[]) {
        int totalWight = 7;
        int[] weight = {1, 3, 4, 5};
        int[] value = {1, 4, 5, 7};
        System.out.println("Recursion : " + knapsack(weight, value, totalWight, 0));
        System.out.println("DP : " + DP(weight, value, totalWight));
    }

    public static int knapsack(int[] weight, int[] value, int weightRemaining, int itemNumber) {
        // System.out.println(weightRemaining + " " + itemNumber);
        // array has been scanned
        if (weight.length == itemNumber) {
            return 0;
        }

        // no space in bag to put items
        if (weightRemaining == 0) {
            return 0;
        }

        /*
            we are picking an item which has crossed the limit,
            so go to right of the recursion tree, ie. don't pick it
        */
        if (weight[itemNumber] > weightRemaining) {
            return knapsack(weight, value, weightRemaining, itemNumber + 1);
        }

        // left tree, ie. picking the item
        int leftMax = value[itemNumber] + knapsack(weight, value, weightRemaining - weight[itemNumber], itemNumber + 1);
        // right tree, ie. not-picking the item
        int rightMax = knapsack(weight, value, weightRemaining, itemNumber + 1);
        return Math.max(leftMax, rightMax);
    }

    public static int DP(int[] weight, int[] value, int totalWeight) {
        int[][] arr = new int[weight.length + 1][totalWeight + 1];

        for (int i = 1; i <= weight.length; i++) {
            for (int j = 1; j <= totalWeight; j++) {
                // if weight is greater than the capacity
                if (j < weight[i - 1]) {
                    arr[i][j] = arr[i - 1][j];
                } else {
                    int includingItem = value[i - 1] + arr[i - 1][j - weight[i - 1]];
                    int excludingItem = arr[i - 1][j];
                    arr[i][j] = Math.max(includingItem, excludingItem);
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

        // which was selected
        int col = totalWeight;
        int tracingValue = arr[weight.length][totalWeight];
        for (int i = value.length; i > 0; i--) {
            if (tracingValue == arr[i - 1][totalWeight]) {
                continue; // means the value came without including current element, ie. from above cell
            } else {
                System.out.print(weight[i - 1] + " "); // currentItem was included
                tracingValue -= value[i - 1]; // reduce value
                col -= weight[i - 1]; // reduce col
            }
        }
        System.out.println();

        return arr[weight.length][totalWeight];
    }
}
