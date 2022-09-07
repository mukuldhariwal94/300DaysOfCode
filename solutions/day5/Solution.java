import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int ints = new Solution().thirdMax(new int[]{1, 1, 2, 2, 2, 3});
    }

    public int thirdMax(int[] nums) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> {
            if (a < b)
                return -1;
            return 1;
        });

        for (int i = 0; i < nums.length; i++) {
            if (!minHeap.contains(nums[i]))
                minHeap.offer(nums[i]);

            if (minHeap.size() > 3) {
                minHeap.poll();
            }
        }

        if (minHeap.size() == 2) {
            minHeap.poll();
            return minHeap.poll();
        }
        if (minHeap.size() == 1)
            return minHeap.poll();

        return minHeap.poll();
    }
}
