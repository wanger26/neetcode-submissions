class Solution {
    public boolean isMonotonic(int[] nums) {
        if (nums.length < 2) {
            return true;
        }

        Boolean increasing = null;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                if (increasing == null) {
                    increasing = true;
                } else if (!increasing) {
                    return false;
                }
            } else if (nums[i] > nums[i + 1]) {
                if (increasing == null) {
                    increasing = false;
                } else if (increasing) {
                    return false;
                }
            }
        }

        return true;
    }
}