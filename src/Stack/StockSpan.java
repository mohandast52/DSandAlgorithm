package Stack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class StockSpan {
    static Stack<Integer> st = null; // to store index
    static ArrayList<Integer> list = null; // to store the actual value, because we want to store the value!
    static int k;

    public StockSpan() {
        st = new Stack<>();
        list = new ArrayList<>();
        k = -1;
    }

    public int next(int price) {
        k++;
        list.add(price);
        if (st.isEmpty()) {
            st.push(k);
            return 1;
        }
        while (!st.isEmpty() && price >= list.get(st.peek())) {
            st.pop();
        }
        /*
        * k + 1 => because the arr can be ascending order. (think index at -1 in arr as greatest element!)
        * k - st.peek() => nearest high element in left side (currentIndex - leftHighElement)
        * */
        int ret = st.isEmpty() ? (k + 1) : (k - st.peek());
        st.push(k);
        return ret;
    }

    public static void main(String args[]) throws IOException {
        // int[] arr = new int[]{1007, 1464, 6977, 453, 5739};
        // int[] arr = new int[]{100, 80, 60, 70, 60, 75, 85};
        int[] arr = new int[]{85, 76, 43, 26, 52};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(new StockSpan().next(arr[i]));
        }
    }
}
