package DataStructure.SlidingWindow;

import java.util.HashSet;
import java.util.Set;

/*
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
* */
public class LongestSubstringWithoutRepeat {
    public int longestSubArray(String s){
       /* //using 2 pointers Brute force
        int left=0, right=left+1,count=1,finalCount = 0;
        char[] strChar= str.toCharArray();
        while(left<strChar.length-2){
            if(strChar[left]!=strChar[right]){
                finalCount=++count;
                right++;
            }
            else{
                left++;
                right=left+1;
                count=1;
            }
        }
        return finalCount;
    }*/
            int left = 0, maxLen = 0;
            Set<Character> set = new HashSet<>();

            for (int right = 0; right < s.length(); right++) {
                while (set.contains(s.charAt(right))) {
                    set.remove(s.charAt(left));
                    left++;
                }
                set.add(s.charAt(right));
                maxLen = Math.max(maxLen, right - left + 1);
            }

            return maxLen;
        }
    public static void main(String[] args) {
        LongestSubstringWithoutRepeat substringWithoutRepeat = new LongestSubstringWithoutRepeat();
        System.out.println(substringWithoutRepeat.longestSubArray("pwwkew"));
    }
}
