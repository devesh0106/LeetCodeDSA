package DataStructure.Heap;

import java.util.*;

public class TopKFrequentElements {

    public int[] mostFrequent(int[] nums, int k) {
        // Step 1: Count frequencies
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Use a Min Heap to keep top K frequent elements
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll(); // remove the least frequent
            }
        }

        // Step 3: Extract keys from the heap
        int[] result = new int[k];
        int i = 0;
        while (!minHeap.isEmpty()) {
            result[i++] = minHeap.poll().getKey();
        }

        return result;
    }

    public static void main(String[] args) {
        TopKFrequentElements topK = new TopKFrequentElements();
        int[] input = {1, 2, 2, 3, 3, 3};
        int[] result = topK.mostFrequent(input, 2);
        System.out.println(Arrays.toString(result)); // Output: [2, 3] or [3, 2]
    }
}
