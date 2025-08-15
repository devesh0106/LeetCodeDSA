package Concepts.TwoPointers;

import java.util.Arrays;


public class Optimal_MoveZeroes {
    public int[] zeroToEnd(int[] nums){
        int insertPos = 0;

        // First pass: Move all non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[insertPos++] = nums[i];
            }
        }

        // Second pass: Fill remaining positions with zeros
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }

        return nums;
    }

    public static void main(String[] args) {
        Optimal_MoveZeroes moveZeroes = new Optimal_MoveZeroes();
        int[] res=moveZeroes.zeroToEnd(new int[]{0,1,0,3,12});
        System.out.println(Arrays.toString(res));
    }
}
