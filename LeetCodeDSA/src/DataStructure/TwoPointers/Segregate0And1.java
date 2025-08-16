package DataStructure.TwoPointers;

import java.util.Arrays;

/*
input : [0,1,0,1,0,1]
output: [0,0,0,1,1,1]
* */
public class Segregate0And1 {
    public int[] zeroAndOne(int[] arr){
       int count0=0, count1=0;
       int[] res= new int[arr.length];
       for(int i=0;i<arr.length;i++){
           if(arr[i]==0){
               count0++;
           }
           else{
               count1++;
           }
       }
       for(int i=0;i<count0;i++){
           res[i]=0;
       }
       for(int i=count0;i<arr.length;i++){
           res[i]=1;
       }
       return res;
    }

    public static void main(String[] args) {
        Segregate0And1 segregate0And1 = new Segregate0And1();
        int[] input= {0,1,0,1,0,1};
        int[] res= segregate0And1.zeroAndOne(input);
        System.out.println(Arrays.toString(res));
    }
}
