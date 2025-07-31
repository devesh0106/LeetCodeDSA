package Concepts.TwoPointers;
/*
Given a string s, return true if it is a palindrome, otherwise return false.

A palindrome is a string that reads the same forward and backward. It is also case-insensitive and ignores all non-alphanumeric characters.

Note: Alphanumeric characters consist of letters (A-Z, a-z) and numbers (0-9).

Example 1:

Input: s = "Was it a car or a cat I saw?"

Output: true
* */
public class ValidPalindrome {
    public boolean isValidPalindrome(String s){
        int l = 0, r = s.length() - 1;

        while (l < r) {
            while (l < r && !alphaNum(s.charAt(l))) { //Skipping non alphaNyumeric from left
                l++;
            }
            while (r > l && !alphaNum(s.charAt(r))) { //Skipping non alphaNyumeric from right
                r--;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            l++; r--;
        }
        return true;
    }
    public boolean alphaNum(char c) {
        return (c >= 'A' && c <= 'Z' ||
                c >= 'a' && c <= 'z' ||
                c >= '0' && c <= '9');
    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        boolean res =validPalindrome.isValidPalindrome("Was it a car or a cat I saw?");
        System.out.println(res);
    }
}
