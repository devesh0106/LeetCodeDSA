package Practice;

import java.util.Arrays;
import java.util.HashSet;

public class RemoveDuplicateElement {
    public static void main(String[] args) {
        //Program to print the duplicate elements of an array
        int[] arr = new int[]{1, 2, 3, 4, 2, 7, 8, 8, 3};
        System.out.println("---------Using Optimise approach--------");
        HashSet<Integer> hs = new HashSet<>();
        System.out.print(" Duplicate elements ");
        int[] res= new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (hs.add(arr[i]) == true) {
                System.out.print(arr[i] + " ");
                res[i]=arr[i];
            }
        }
        System.out.println();
        System.out.println(Arrays.toString(arr)); //Original Array with duplicates
        System.out.println(Arrays.toString(res)); //removed duplicates
    }
}
