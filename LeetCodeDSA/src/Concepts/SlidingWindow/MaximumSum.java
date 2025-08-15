package Concepts.SlidingWindow;
/*
Given an array of integers and a number k, find the maximum sum of any contiguous subarray of size k.
Input: arr = [2, 1, 5, 1, 3, 2], k = 3
Output: 9
Explanation: Subarray [5, 1, 3] has the largest sum = 9
* */
public class MaximumSum {

    public int maximumSumofSubArray(int[] arr, int k){
        int maxSum=Integer.MAX_VALUE, winSum=0;
        //Sum of first k elements
        for(int winStart=0;winStart<k;winStart++){
            winSum+=arr[winStart];
        }
        maxSum=winSum;

        //Slide the window and substract element going out of a window
        for(int winEnd=k;winEnd<arr.length;winEnd++){
            winSum+=arr[winEnd]-arr[winEnd-k];
            maxSum=Math.max(maxSum,winSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        MaximumSum maximumSum= new MaximumSum();
        int[] arr = {1,5,4,2,9,9,9};
        int k = 3;
        System.out.println(maximumSum.maximumSumofSubArray(arr, k)); // Output: 9
    }
}
