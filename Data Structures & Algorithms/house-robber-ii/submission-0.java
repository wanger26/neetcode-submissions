class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        return Math.max(robRange(nums, 0, nums.length-1), robRange(nums, 1, nums.length));
    }

    private int robRange(int[] nums, int start, int end) {
        int robPrevHouse = 0;
        int notRobPreviousHouse = 0;

        for(int i=start; i < end; i++) {
            int robCurrentHouse = notRobPreviousHouse + nums[i];
            notRobPreviousHouse = Math.max(notRobPreviousHouse, robPrevHouse);
            robPrevHouse = robCurrentHouse;
        }

        return Math.max(robPrevHouse, notRobPreviousHouse);
    }
}
