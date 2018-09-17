package DP;

import java.util.Arrays;

public class MinimumJump {
    public static void main(String args[]) throws Exception {
        int arr[] = {2, 3, 1, 6, 3, 2};
        int n = arr.length;
        System.out.println("Minimum number of jumps to reach end is " + minJumps(arr, 0, n - 1));
        System.out.println(DPjumps(arr));
    }


    private static int minJumps(int[] arr, int l, int h) {

        if (l == h) {
            return 0;
        }

        if (arr[l] == 0) {
            return Integer.MAX_VALUE;
        }

        int min = Integer.MAX_VALUE;
        for (int i = l + 1; i <= h && i <= arr[l] + l; i++) {
            // System.out.println(i + " " + h);
            int jumps = minJumps(arr, i, h);
            if (jumps != Integer.MAX_VALUE && min > jumps + 1) {
                min = jumps + 1;
            }
        }
        return min;
    }

    public static int DPjumps(int[] arr) {
        int[] minDist = new int[arr.length];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] + j >= i) {
                    minDist[i] = Math.min(minDist[i], minDist[j] + 1);
                }
            }
        }
        System.out.println(Arrays.toString(minDist));
        return minDist[minDist.length - 1];
    }
}
// https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/ (recursive nai hua)
//
