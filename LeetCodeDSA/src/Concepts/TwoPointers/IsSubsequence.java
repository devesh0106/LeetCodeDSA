package Concepts.TwoPointers;
/*
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters.
(i.e., "ace" is a subsequence of "abcde" while "aec" is not).
Example 1:
Input: s = "abc", t = "ahbgdc"
Output: true
* */
public class IsSubsequence {
    public boolean validSequence(String seq, String str){
            int i=0,j=0;
            while(i<seq.length() && j<str.length()){
                if(seq.charAt(i)==str.charAt(j)){
                    i++;
                }
                j++;
            }
        return i==seq.length();
    }

    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();
        System.out.println(isSubsequence.validSequence("abc","ahbgdc")); //true
        System.out.println(isSubsequence.validSequence("acb","ahbgdc")); //false
        System.out.println(isSubsequence.validSequence("abx","ahbgdc")); //false
    }
}
