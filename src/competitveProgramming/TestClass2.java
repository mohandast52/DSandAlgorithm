package competitveProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;


public class TestClass2 {
    private final TrieNode root;

    public TestClass2() {
        root = new TrieNode(-1);
    }

    public class TrieNode {
        Map<Character, TrieNode> childrens;
        int weight;


        public TrieNode(int wt) {
            this.childrens = new HashMap<>();
            this.weight = wt;
        }

        @Override
        public String toString() {
            return childrens.toString() + " " + weight;
        }
    }

    public void insert(String word, int wt) {
        TrieNode parent = root;
        for (int i = 0; i < word.length(); i++) {
            // System.out.println(root);
            Character currentChar = word.charAt(i);
            TrieNode child = parent.childrens.get(currentChar);
            if (child == null) {
                child = new TrieNode(wt);
                parent.childrens.put(currentChar, child);
            } else {
                child.weight = Math.max(child.weight, wt);
            }
            parent = child;
        }
    }

    private int find(String word) {
        TrieNode parent = root;
        for (int i = 0; i < word.length(); i++) {
            Character currentChar = word.charAt(i);
            TrieNode child = parent.childrens.get(currentChar);
            if (child == null) {
                return -1;
            }
            parent = child;
        }
        return parent.weight;
    }

    public static void main(String args[]) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TestClass2 parentOfAll = new TestClass2();

        String[] line = reader.readLine().trim().split("\\s+");
        int t = Integer.parseInt(line[0]);
        int q = Integer.parseInt(line[1]);
        while (t-- > 0) {
            String[] tpLine = reader.readLine().trim().split("\\s+");
            String word = (tpLine[0]);
            int wt = Integer.parseInt(tpLine[1]);
            parentOfAll.insert(word, wt);
        }

        while (q-- > 0) {
            String word = reader.readLine().trim();
            out.println(parentOfAll.find(word));
        }
        out.flush();
    }
}

/*
            int C = Integer.parseInt(line1[1]);

            String[] line2 = reader.readLine().trim().split("\\s+");
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(line2[i]);
            }



            int t = Integer.parseInt(reader.readLine().trim());
            while (t-- > 0) {
                String[] line1 = reader.readLine().trim().split("\\s+");
                int X = Integer.parseInt(line1[0]);
                int Y = Integer.parseInt(line1[1]);


                out.println();
            }
*/
