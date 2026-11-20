class Solution {
    public int lengthOfLIS(int[] nums) {

        // Time: O(n^2)
        // Space: O(n^2)
        int n = nums.length;
        int[][] memo = new int[n][n+1];
        for(int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        return dp(nums, 0, -1, memo);
    }

    private int dp(int[] nums, int index, int prevIndex, int[][] memo) {
        if(index == nums.length) {
            return 0;
        } else if (memo[index][prevIndex+1] != -1) {
            return memo[index][prevIndex+1];
        }

        int result = 0;
        // Option 1: Use current num
        if(prevIndex == -1 || (nums[prevIndex] < nums[index])) {
            result = 1 + dp(nums, index+1, index, memo);
        }

        // Option 2: Do not use current num
        result = Math.max(result, dp(nums, index+1, prevIndex, memo));

        memo[index][prevIndex+1] = result;

        return result;
    }
}
