package DataStructure.Arrays.Hashing;

import java.util.HashMap;
import java.util.Map;

/*
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in the magazine can only be used once in ransomNote.
Example 1:
Input: ransomNote = "a", magazine = "b"
Output: false
Input: ransomNote = "aa", magazine = "aab"
Output: true
* */
public class RansomNote {
        public boolean validRansomNote(String ransomNote, String magazine){
            // Step 1: Build frequency map for a magazine
            Map<Character, Integer> magazineCount = new HashMap<>();
            for (char c : magazine.toCharArray()) {
                magazineCount.put(c, magazineCount.getOrDefault(c, 0) + 1);
            }

            // Step 2: Check each character in ransomNote
            for (char c : ransomNote.toCharArray()) {
                if (!magazineCount.containsKey(c) || magazineCount.get(c) == 0) {
                    return false; // not enough letters
                }
                magazineCount.put(c, magazineCount.get(c) - 1); // use one letter
            }
            return true;
        }

    public static void main(String[] args) {
        RansomNote ransomNote = new RansomNote();
        boolean res= ransomNote.validRansomNote("aa","aab");
        System.out.println(res);
    }
}
