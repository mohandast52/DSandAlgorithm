package Backtracking;

import java.util.*;

public class Permutation {
    public static void main(String args[]) {
//        permuteWithDuplicates("AABC");
//        permuteWithoutDuplicates("AABC");
        List<List<Integer>> ak = combine(4, 2);
        for (List<Integer> l : ak) {
            System.out.println(l);
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        permute(result, n, k, 1, list, new ArrayList<>());
        return result;
    }

    public static void permute(List<List<Integer>> result, int n, int k, int start, List<Integer> list, List<Integer> temp) {
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        } else {
            for (int i = start; i <= n; i++) {
                // int removed = list.remove(i - 1);
                // temp.add(removed);
                temp.add(i);
                permute(result, n, k, i + 1, list, temp);
                // list.add(i - 1, removed);
                temp.remove(temp.size() - 1); // removing last item, which was recently added
            }
        }
    }

    private static void permuteWithDuplicates(String str) {
        System.out.println("Duplicates Allowed");
        char[] charArray = "AABC".toCharArray();
        List<Character> list = new ArrayList<>();
        for (Character ch : charArray) {
            list.add(ch);
        }
        List<Character> chosen = new ArrayList<>();
        permute(list, chosen);


    }

    // we can see that duplicate character repeats the permutation (time complexity : n!)
    public static void permute(List<Character> list, List<Character> chosen) {
        if (list.size() == 0) {
            System.out.println(chosen);
        } else {
            for (int i = 0; i < list.size(); i++) {

                // remove a character and add to chosen
                Character removedChar = list.remove(i);
                chosen.add(removedChar);
                permute(list, chosen);

                // again, add the removed char
                list.add(i, removedChar);
                // remove from the chosen too
                chosen.remove(chosen.size() - 1);
            }
        }
    }

    public static void permuteWithoutDuplicates(String str) {
        System.out.println("\n\nDuplicated not allowed");
        char[] charArray = str.toCharArray();
        Map<Character, Integer> characterMap = new TreeMap<>();
        for (char eachChar : charArray) {
            characterMap.compute(eachChar, (key, value) -> {
                if (value == null) {
                    return 1;
                } else {
                    return value + 1;
                }
            });
        }
        char strArray[] = new char[characterMap.size()];
        int count[] = new int[characterMap.size()];
        int index = 0;
        for (Map.Entry<Character, Integer> entry : characterMap.entrySet()) {
            strArray[index] = entry.getKey();
            count[index] = entry.getValue();
            index++;
        }
        char result[] = new char[charArray.length];
        permute(strArray, count, result, 0);
    }

    public static void permute(char[] strArray, int[] count, char[] result, int level) {
        if (level == result.length) {
            System.out.println(Arrays.toString(result));
            return;
        }

        for (int i = 0; i < strArray.length; i++) {
            if (count[i] == 0) {
                continue; // that has been included already
            } else {
                result[level] = strArray[i];
                count[i]--;
                permute(strArray, count, result, level + 1);
                count[i]++;
            }
        }
    }
}

/*
https://www.geeksforgeeks.org/internal-working-of-hashmap-java/
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
          list.add(i);
        }
        permute(result, n, k, list, new ArrayList<>());
        return result;
    }

    public static void permute(List<List<Integer>> result, int n, int k, List<Integer> list, List<Integer> temp){
      if(temp.size() == k){
        result.add(new ArrayList<Integer>(temp));
        return;
      } else {
        for(int i = 1; i <= list.size(); i++){
          int removed = list.remove(i - 1);
          temp.add(removed);
          permute(result, n, k, list, temp);
          list.add(i - 1, removed);
          temp.remove(temp.size() - 1); // removing last item, which was recently added
        }
      }
    }
}
*/

