class Solution {
    public int rob(int[] nums) {
        // Time: O(n)
        // Space: O(n)
        return dp(nums, 0, new int[nums.length]);
    }

    private int dp(int[] nums, int index, int[] memo) {
        if(nums.length <= index) {
            return 0;
        } else if (memo[index] != 0) {
            return memo[index];
        }

        // Option 1: If can rob, we can choose to rob it
        int result = nums[index] + dp(nums, index + 2, memo);

        // Option 2: Do not rob this place. So we can rob the next one.
        result = Math.max(result, dp(nums, index + 1, memo));

        memo[index] = result;
        return result;
    }
}
