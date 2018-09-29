package competitveProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class TestSetsMaps {
    public static void main(String[] args) {
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            ArrayList<Integer> listTemp = null;
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
    public static String largestNumber(final int[] A) {
        ArrayList<Integer> list = new ArrayList<>();
        StringBuffer answer = new StringBuffer();

        for (int i = 0; i < A.length; i++) {
            list.add(A[i]);
        }

        Collections.sort(list, (o1, o2) -> {
            String s_1 = o1.toString();
            String s_2 = o2.toString();
            String case1 = s_1 + s_2;
            String case2 = s_2 + s_1;
            return case2.compareTo(case1);

        });

        for (int i = 0; i < list.size(); i++) {
            answer.append(list.get(i));
        }

        while (answer.charAt(0) == '0' && answer.length() > 1) {
            answer.delete(0, 1);
        }

        return answer.toString();
    }
}
