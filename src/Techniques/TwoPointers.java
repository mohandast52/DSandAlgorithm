package Techniques;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoPointers {
    public static void main(String args[]) {
        int M = 8;
        int[] A = {5, 2, 9, 4, 4, 2, 10};
        System.out.println(Arrays.toString(fizzBuzz(5)));
    }

    // merge 2 sorted array and add to firstArrayList (interviewBit)
    public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        int l = a.size() - 1;
        int r = b.size() - 1;
        while (l >= 0 && r >= 0) {
            if (a.get(l) > b.get(r)) {
                l--;
            } else {
                a.add(l + 1, b.get(r));
                r--;
            }
        }

        while (r >= 0) {
            a.add(l + 1, b.get(r));
            r--;
        }
    }

    /*
        Find the intersection of two sorted arrays. (interviewBit)
        Input :
        A : [1 2 3 3 4 5 6]
        B : [3 3 5]
        Output : [3 3 5]
    */
    public int[] intersect(final int[] A, final int[] B) {
        ArrayList<Integer> list = new ArrayList<>();
        int l = 0;
        int r = 0;
        while (l < A.length && r < B.length) {
            if (A[l] == B[r]) {
                list.add(A[l]);
                l++;
                r++;
            } else {
                if (A[l] < B[r]) {
                    l++;
                } else {
                    r++;
                }
            }
        }
        int[] a = new int[list.size()];
        int i = 0;
        for (int k : list) {
            a[i++] = k;
        }
        return a;
    }

    public static String[] fizzBuzz(int A) {
        String[] arr = new String[A];
        for (int i = 1; i <= 5; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                arr[i - 1] = "FizzBuzz";
            } else if (i % 3 == 0) {
                arr[i - 1] = "Fizz";
            } else if (i % 5 == 0) {
                arr[i - 1] = "Buzz";
            } else {
                arr[i - 1] = i + "";
            }
        }
        return arr;
    }

}
