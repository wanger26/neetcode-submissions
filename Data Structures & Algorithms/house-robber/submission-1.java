class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        return dp(nums, 0, memo);
    }

    private int dp(int[] nums, int index, int[] memo) {

        if(index >= nums.length) {
            return 0;
        } else if (memo[index] != 0) {
            return memo[index];
        }

        int result = 0;
        
        // Option 1: Rob the house
        result = nums[index] + dp(nums, index+2, memo);

        // Option 2: Do not rob this house
        result = Math.max(result, dp(nums, index+1, memo));

        memo[index] = result;
        return result;
    }
}
