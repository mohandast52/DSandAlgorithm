package Math;

import java.util.Arrays;

public class catalanNumbers {
    public static void main(String[] args) {
        int[] arr = new int[20];
        arr[0] = 1;
        for (int j = 1; j < arr.length; j++) {
            int sum = 0;
            for (int i = 0; i < j; i++) {
                sum += (arr[i] * arr[j - i - 1]);
            }
            arr[j] = sum;
        }

        System.out.println(Arrays.toString(arr));
    }
}
