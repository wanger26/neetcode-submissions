class Solution {
    public int maxCoins(int[] nums) {

        // Time: O(n^3)
        // Space: O(n^2)
        int n = nums.length;
        int[][] memo = new int[n][n];
        return dp(nums, 0, nums.length-1, memo);
    }

    private int dp(int[] nums, int left, int right, int[][] memo) {
        if(right < left) {
            return 0;
        } else if (memo[left][right] != 0) {
            return memo[left][right];
        }

        int result = 0;
        int leftValue = left - 1 < 0 ? 1 : nums[left - 1];
        int rightValue = right + 1 >= nums.length ? 1 : nums[right+1];
        for(int i = left; i <= right; i++) {
            // Choose this as the last element to be popped
            result = Math.max(result, leftValue * nums[i] * rightValue + dp(nums, left, i - 1, memo) + dp(nums, i + 1, right, memo));
        }

        memo[left][right] = result;
        return result;
    }
}
