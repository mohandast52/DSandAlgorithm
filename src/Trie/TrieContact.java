package Trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/*
* https://www.youtube.com/watch?v=vlYZb68kAY0
* https://www.hackerrank.com/challenges/ctci-contacts/problem?h_r=internal-search ===> HARD
* */
public class TrieContact {
    private final TrieNode root;

    public TrieContact() {
        root = new TrieNode();
    }

    public class TrieNode {
        Map<Character, TrieNode> childrens;
        int prefixCount;

        public TrieNode() {
            this.childrens = new HashMap<Character, TrieNode>();
            this.prefixCount = 1;
        }

        @Override
        public String toString() {
            return childrens.toString() + " " + prefixCount;
        }
    }

    public void insert(String word) {
        TrieNode parent = root;
        for (int i = 0; i < word.length(); i++) {
            System.out.println(root);
            Character currentChar = word.charAt(i);
            TrieNode child = parent.childrens.get(currentChar);
            if (child == null) {
                child = new TrieNode();
                parent.childrens.put(currentChar, child);
            } else {
                child.prefixCount++;
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
                return 0;
            }
            parent = child;
        }
        return parent.prefixCount;
    }

    public static void main(String args[]) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TrieContact parentOfAll = new TrieContact();

        int t = Integer.parseInt(reader.readLine().trim());
        while (t-- > 0) {
            String[] line = reader.readLine().trim().split("\\s+");
            String q = (line[0]);
            String word = (line[1]);

            if (q.trim().equals("add")) {
                parentOfAll.insert(word);
            } else {
                out.println(parentOfAll.find(word));
            }
        }
        out.flush();
    }
}

/*

5
add abc
add abcd
add ab
find abc
find a

*/
