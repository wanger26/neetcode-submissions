class Solution {
    public int rob(int[] nums) {

        // Time: O(n)
        // Space: O(1)
        if (nums.length == 1) {
            return nums[0];
        }

        return Math.max(robRange(nums, 0, nums.length - 1), robRange(nums, 1, nums.length));
    }

    private int robRange(int[] nums, int start, int end) {
        int result = 0;
        int robPreviousHouse = 0;
        int notRobPreviousHouse = 0;

        for (int i = start; i < end; i++) {
            int robCurrentHouse = nums[i] + notRobPreviousHouse;
            notRobPreviousHouse = Math.max(notRobPreviousHouse, robPreviousHouse);
            robPreviousHouse = robCurrentHouse;
        }

        return Math.max(robPreviousHouse, notRobPreviousHouse);
    }
}
