package DataStructure.Heap;

import java.util.HashMap;
import java.util.Map;

/*
Given an integer array nums and an integer k, return the k most frequent elements within the array.

The test cases are generated such that the answer is always unique.

You may return the output in any order.

Example 1:

Input: nums = [1,2,2,3,3,3], k = 2

Output: [2,3]
* */
public class Tried_TopKFrequentElements {
    public int[] mostFrequent(int[] nums,int k){
        //Step1: count the frequency of numbers
        //Step2: compare count with given frequency and print array of elements
        Map<Integer,Integer> mp= new HashMap<>();
        int[] frequency = new int[nums.length];
         int key=0,value = 0;
        for(int i=0;i<nums.length;i++){
            int count=0;
            for(int j=i;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    count+=1;
                }
            }
            mp.put(nums[i],count);
        }
        for(Map.Entry<Integer,Integer> i :mp.entrySet()){
                 key= i.getKey();
                 value = i.getValue();
        }
        if(value > k){
           frequency = new int[]{key};
        }
        return frequency;
    }

    public static void main(String[] args) {
        Tried_TopKFrequentElements topKFrequentElements = new Tried_TopKFrequentElements();
        int[] input = new int[]{1,2,2,3,3,3};
        System.out.println(topKFrequentElements.mostFrequent(input,2));
    }

}
