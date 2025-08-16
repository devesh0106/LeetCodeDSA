package DataStructure.TwoPointers;

import java.util.Arrays;

public class TwoPointer_Segregate0And1 {
    public int[] solution(int[] arr){
        int left=0, right = arr.length-1;
        while(left<right){
            if(arr[left]==1 || arr[right]==0){
                arr[left]=0;
                arr[right]=1;
                left++;
            }
             right--;
        }
        return arr;
    }

    public static void main(String[] args) {
    TwoPointer_Segregate0And1 segregate0And1 = new TwoPointer_Segregate0And1();
    int[] input = {0,1,0,1,0,1};
        int[] input2 = {0,1,1,0,1,0,0,1,0,0,1};
        System.out.println(Arrays.toString(segregate0And1.solution(input)));
        System.out.println(Arrays.toString(segregate0And1.solution(input2)));
    }
}
