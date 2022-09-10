class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean increasing = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                increasing = false;
                break;
            }
        }

        boolean descreasing = true;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                descreasing = false;
                break;
            }
        }

        return increasing || descreasing;
    }
}