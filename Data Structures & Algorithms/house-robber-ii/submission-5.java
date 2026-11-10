class Solution {
    public int rob(int[] nums) {

        // Time: O(n)
        // Space: O(n)
        if(nums.length == 1) {
            return nums[0];
        }

        int n = nums.length;
        return Math.max(dp(nums, 0, n-1, new int[n]), dp(nums, 1, n, new int[n]));
    }

    private int dp(int[] nums, int index, int length, int[] memo) {
        if(index >= length) {
            return 0;
        } else if (memo[index] != 0) {
            return memo[index];
        }

        // Option 1: Rob current house
        int result = nums[index] + dp(nums, index+2, length, memo);

        // Option 2: Do not rob current house
        result = Math.max(result, dp(nums, index + 1, length, memo));

        memo[index] = result;

        return result;
    }
}
