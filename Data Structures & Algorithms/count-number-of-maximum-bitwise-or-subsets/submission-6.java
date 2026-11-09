class Solution {
    public int countMaxOrSubsets(int[] nums) {

        // Time: O(2^n)
        // Space: O(n)
        int target = 0;
        for (int num : nums) {
            target |= num;
        }

        return dp(nums, 0, 0, target);
    }

    private int dp(int[] nums, int index, int current, int target) {
        if (current == target) {
            return (int) Math.pow(2, nums.length - index);
        } else if (nums.length == index) {
            return 0;
        }

        // Option 1: Include current
        int result = dp(nums, index + 1, current | nums[index], target);

        // Option 2: Skip current
        result += dp(nums, index + 1, current, target);

        return result;
    }
}
