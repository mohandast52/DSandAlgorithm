package Trie;

import java.util.*;

public class Trie {

    private final TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    private static class TrieNode {
        HashMap<Character, TrieNode> map;
        boolean isCompleteString;

        public TrieNode() {
            map = new HashMap<>();
            isCompleteString = false;
        }

        @Override
        public String toString() {
            return map.toString() ;
        }
    }

    private void insert(String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = currentNode.map.get(ch); // get the node having that character
            if (node == null) /* if that character is not present, create node and put the reference to parent's map */ {
                node = new TrieNode();
                currentNode.map.put(ch, node);
            }
            currentNode = node; // else child node is present and get the node!
        }
        // mark the last one as true, as it completes the string
        currentNode.isCompleteString = true;
    }

    private boolean search(String word) {
        TrieNode currentNode = root;
        // System.out.println(root.toString());
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            currentNode = currentNode.map.get(ch);
            if (currentNode == null) return false; // node is not represent
        }
        return currentNode.isCompleteString; // we reached end of the string, and if that node is completed, it will have true!
    }

    public void delete(String word) {
        delete(root, word, 0);
    }

    private boolean delete(TrieNode parentNode, String word, int index) {
        // if we have same prefix for different strings, then we can't remove any node, but instead make isCompleteString to false from true!

        // end of the string
        if (word.length() == index) {
            if (!parentNode.isCompleteString) {
                return false; // the string is not available;
            }

            parentNode.isCompleteString = false;

            // if 0, return true ie. to delete the node! if not 0, then more words are present with same prefix
            return parentNode.map.size() == 0;
        }

        char currentCharacter = word.charAt(index);
        TrieNode childNode = parentNode.map.get(currentCharacter);
        if (childNode == null) {
            return false;
        }

        boolean shouldDeleteCurrent = delete(childNode, word, index + 1);
        if (shouldDeleteCurrent) {
            parentNode.map.remove(currentCharacter);
            return parentNode.map.size() == 0;
        }

        return false;
    }

    public static void main(String args[]) {
        final List<String> stringList = new ArrayList<>();
        stringList.add("abc");
        stringList.add("abgl");
        stringList.add("cdf");
        stringList.add("abcd");
        stringList.add("lmn");
        stringList.add("hack");
        Trie node = new Trie();
        for (String str : stringList) {
            node.insert(str);
        }

        System.out.println(node.search("abgl"));
        node.delete("abgl");
        System.out.println(node.search("abgl"));
        System.out.println(node.search("abcd"));
        System.out.println(node.search("abc"));
    }
}

/*
* Programs completed after learning TRIE
*
* */
