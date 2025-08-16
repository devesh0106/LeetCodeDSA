package DataStructure.Arrays.Hashing;

import java.util.HashSet;

/*
Note: HashSet doesn't allow duplicate and sort the values.
* Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.
*
Input: nums = [1, 2, 3, 3], Output: true
Input: nums = [1, 2, 3, 4] , Output: false
Input: nums=[2,2,1,1,3,1,2,3,1,4], Output: true
* */
public class ContainsDuplicate {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0;i<nums.length;i++){
            if(!hs.add(nums[i]))
            {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate cd=  new ContainsDuplicate();
        int[] nums = {2,2,1,1,3,1,2,3,1,4};
        System.out.println(cd.hasDuplicate(nums));
    }
}
