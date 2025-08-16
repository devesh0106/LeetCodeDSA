package DataStructure.TwoPointers;

import java.util.Arrays;

/*
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
* */
public class BruteForce_MoveZeroes {
    public int[] zeroToEnd(int[] arr){
        int left=0,right=left+1,temp=0;
        while(left<arr.length-2){
            if(arr[left]==0 && arr[right]!=0){
                temp=arr[left];
                arr[left]= arr[right];
                arr[right]= temp;
                left++;
            }
            else if(arr[left] ==0 && arr[right]==0 )
            {
                right++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        BruteForce_MoveZeroes moveZeroes = new BruteForce_MoveZeroes();
        int[] res=moveZeroes.zeroToEnd(new int[]{0,1,0,3,12});
        System.out.println(Arrays.toString(res));
    }
}
