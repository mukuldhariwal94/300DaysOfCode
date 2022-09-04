import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int[] ints = frequencySort(new int[]{1, 1, 2, 2, 2, 3});
    }

    public static int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<Map.Entry<Integer, Integer>>((o1, o2) -> {
            return o1.getValue() == o2.getValue() ? o1.getKey() - o2.getKey() : o1.getValue() - o2.getValue();
        });
        for (int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i], 0);
            map.put(nums[i], ++count);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(entry);
        }
        int i = 0;
        while (!queue.isEmpty()) {
            Map.Entry<Integer, Integer> entry = queue.poll();
            int freq = entry.getValue();

            while (freq != 0) {
                nums[i++] = entry.getKey();
                freq--;
            }
        }

        return nums;
    }
}
