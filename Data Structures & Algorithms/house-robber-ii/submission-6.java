class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        return Math.max(robRange(nums, 0, nums.length - 1), robRange(nums, 1, nums.length));
    }

    private int robRange(int[] nums, int start, int end) {
        int result = 0;
        int robPreviousHosue = 0;
        int notRobPreviousHouse = 0;

        for (int i = start; i < end; i++) {
            int robCurrentHouse = nums[i] + notRobPreviousHouse;
            notRobPreviousHouse = Math.max(notRobPreviousHouse, robPreviousHosue);
            robPreviousHosue = robCurrentHouse;
        }

        return Math.max(robPreviousHosue, notRobPreviousHouse);
    }
}
