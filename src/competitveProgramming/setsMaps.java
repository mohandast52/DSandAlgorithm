package competitveProgramming;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class setsMaps {
    public static void main(String[] args){
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            ArrayList<Integer> listTemp = null;
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
