package Practice;

import java.util.Arrays;
import java.util.TreeSet;

public class RemoveDuplicatesAndSort {
    public int[] solution(int[] nums) {
        TreeSet<Integer> hs = new TreeSet<>();
        for (int num : nums) {
            hs.add(num);  // TreeSet removes duplicates and keeps order sorted
        }
        System.out.println("Ordered Elements "+hs);
        // Convert TreeSet to array
        int[] res = new int[hs.size()];
        int index = 0;
        for (int num : hs) {
            res[index++] = num;
        }

        return res;
    }

    public static void main(String[] args) {
        RemoveDuplicatesAndSort removeDuplicatesAndSort = new RemoveDuplicatesAndSort();
        System.out.println(Arrays.toString(removeDuplicatesAndSort.solution(new int[]{4, 2, 1, 1, 2, 3})));
    }
}
