package Concepts.TwoPointers;

import java.util.Arrays;

/*
Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
* */
public class RemoveDuplicatesFromSortedArrayWithOptimalSpace {
    public int solution(int[] nums){
        int k=1;
        for(int i=1;i< nums.length;i++){
            if(nums[i]!=nums[k-1]){
                nums[k]=nums[i];
                k++;
            }
        }
        for (int i = 0; i < k; i++) {
            nums[i]=nums[i];
        }
        return k;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayWithOptimalSpace duplicates = new RemoveDuplicatesFromSortedArrayWithOptimalSpace();
        int[] nums=new int[]{1,1,2};
        int k = duplicates.solution(nums);
        System.out.println(k);
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
