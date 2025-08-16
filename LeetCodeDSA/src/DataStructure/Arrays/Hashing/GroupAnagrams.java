package DataStructure.Arrays.Hashing;

import java.util.*;
import java.util.List;/*

Given an array of strings strs, group all anagrams together into sublists. You may return the output in any order.

An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.

Example 1:

Input: strs = ["act","pots","tops","cat","stop","hat"]

Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]
* */
/*
Step 1: Input Array of String
          Step 2: count length of strings...if not equal.don't count frequency.
          Step 3: count the frequency of characters in each string
          Step 4: compare strings
          Step 5: create a list of lists for all compared strings.
        */
//Solution 1 : sort the strings and compare all 'm' strings. m*nlogn
public class GroupAnagrams {
    public List<List<String>> groupAnagram(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(s);
        }
        return new ArrayList<>(res.values());
    }


    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        String[] strs = new String[]{"act", "pots", "tops", "cat", "stop", "hat"};
        System.out.println(ga.groupAnagram(strs));
    }
}