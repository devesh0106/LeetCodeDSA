package DataStructure.TwoPointers;

import java.util.TreeSet;

/*
Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
* */
public class RemoveDuplicatesFromSortedArray {
        public int solution(int[] nums){
            TreeSet<Integer> hs = new TreeSet<>();
            for(int num:nums){
                hs.add(num); // removed duplicates
            }
            int k=0;
            for(int num: hs){ //converted hashset into an array
                nums[k++]=num;
            }
            return k; // returning k : (count of unique elements)
        }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
        System.out.println(removeDuplicatesFromSortedArray.solution(new int[]{1,1,2,2,3}));
    }
}
