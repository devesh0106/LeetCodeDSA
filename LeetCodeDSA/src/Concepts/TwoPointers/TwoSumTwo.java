package Concepts.TwoPointers;
/*
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
Here index is plus 1
*/

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumTwo {
    public int[] solution(int[] arr, int target){
        int left=0, right=arr.length-1;
        HashMap<Integer,Integer> mp = new HashMap<>();
        while(left<=right){
            int complement=target-arr[left];
            if(mp.containsKey(complement)){
                int[] res = new int[]{mp.get(complement)+1,left+1};
                return res;
                }
            mp.put(arr[left],left);
            left++;
            }

        return  new int[0];
    }

    public static void main(String[] args) {
        TwoSumTwo twoSumTwo = new TwoSumTwo();
        int[] res =twoSumTwo.solution(new int[]{2,3,4}, 6);
        System.out.println(Arrays.toString(res));
    }
}
