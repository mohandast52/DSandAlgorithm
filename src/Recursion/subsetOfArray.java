package Recursion;

import java.util.ArrayList;
import java.util.List;

public class subsetOfArray {
    static List<List<Integer>> subsets = new ArrayList<>();
    static int[] arr = {
            1, 2, 3, 4, 5
            // , 6, 7, 8, 9, 10
            // , 11, 12, 13, 14, 15
            // , 16, 17, 18, 19, 20
    };

    public static void main(String args[]) throws Exception {
        /*
        subsets = arrayOfSubts(arr);
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
        */

        // call bitSet()
        bitSet();
        System.out.println((int)Math.pow(2, 30));
    }

    private static List<List<Integer>> arrayOfSubts(int[] arr) {
        System.out.println("Using Recursion");
        subsetHelper(new ArrayList<>(), 0);
        return subsets;
    }

    private static void subsetHelper(ArrayList<Integer> result, int start) {
        subsets.add(new ArrayList<>(result));
        for (int i = start; i < arr.length; i++) {
            result.add(arr[i]);
            /*
            System.out.println("--Now, the subset is--");
            for (List<Integer> subset : subsets) {
                System.out.println(subset);
            }
            System.out.println("-----------------------");
            */
            subsetHelper(result, i + 1);
            result.remove(result.size() - 1);
        }
    }

    // bitset approach
    private static void bitSet() {
        System.out.println("\n\nUsing BITset");
        for (int i = 0; i < (1 << arr.length); i++) {
            System.out.print("{");

            for (int j = 0; j < arr.length; j++) {
                /*
                   eg]  6 : 0 1 0 1
                            check if every bit is set ie.
                            (0 1 0 1) & (0 0 0 1) != 0
                            (0 1 0 1) & (0 0 1 0) == 0
                            (0 1 0 1) & (0 1 0 0) != 0
                            (0 1 0 1) & (1 0 0 0) == 0

                            if( !=0 ) print that array value
                */
                if ((i & (1 << j)) != 0) {
                    System.out.print(" " + arr[j]);
                }
            }
            System.out.print(" }\n");
        }
    }
}

