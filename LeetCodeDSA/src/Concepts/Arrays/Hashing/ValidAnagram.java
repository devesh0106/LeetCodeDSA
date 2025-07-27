package Concepts.Arrays.Hashing;
/*
*
* Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.

An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.

Example 1:

Input: s = "racecar", t = "carrace"

Output: true
* */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count = new int[26]; // assuming lowercase letters only

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int c : count) {
            if (c != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        ValidAnagram va = new ValidAnagram();
        System.out.println(va.isAnagram("racecar","carrace"));
    }
}
/*
🔹 s.charAt(i)
Gets the character at index i of the string s.,
For example, if s = "racecar" and i = 0, then s.charAt(0) is 'r'.
🔹 'r' - 'a'
In Java, characters are internally represented by their ASCII/Unicode values.
So:
'a' has value 97
'r' has value 114
So:'r' - 'a' = 114 - 97 = 17
* */

