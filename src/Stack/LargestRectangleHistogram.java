package Stack;

import java.io.IOException;
import java.util.Stack;

public class LargestRectangleHistogram {
    /*
    * https://www.youtube.com/watch?v=MhQPpAoZbMc
    * https://www.youtube.com/watch?v=RVIh0snn4Qc
    */
    public static void main(String[] args) throws IOException {
        System.out.println(largestRectangleArea(new int[]{1, 2, 3, 4, 5, 3, 3, 2}));
    }

    public static long largestRectangleArea(int[] A) {
        Stack<Integer> stack = new Stack<>();
        long max = 0;
        int i = 0;
        while (i < A.length) {
            if (stack.isEmpty() || A[stack.peek()] <= A[i]) {
                /*
                * If stack isEmpty() push something! OR
                * the element at 'i' pointer pointing is same as element at top() of the stack
                *     ___
                *   __| |
                * __| | |__
                * | | | | |
                * | | | | |
                * | | | | |
                *
                * here the '0th' index is same as '3rd' index so we want to push it and calculate later,
                * as '0th' index can expand to '3rd' or later indexes
                * */
                stack.push(i);
                i++;
            } else {
                int area = A[stack.pop()];
                if (stack.isEmpty()) {
                    area = area * i;
                } else {
                     /*
                      * i has already incremented, so (i - 1) i.e right side small element and
                      * stack.peek() is the left side small element
                      * */
                    area = area * (i - 1 - stack.peek());
                }
                max = Math.max(area, max);
            }
        }

        while (!stack.isEmpty()) {
            int area = A[stack.pop()];
            if (stack.isEmpty()) {
                area = area * i;
            } else {
                area = area * (i - 1 - stack.peek());
            }
            max = Math.max(area, max);
        }
        return max;
    }

}
