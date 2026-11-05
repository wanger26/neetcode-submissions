class Solution {
    public boolean canJump(int[] nums) {
        // Time: O(n*min(m,n) where m is the largest jump
        // Space: O(n)
        return dp(nums, 0, new Boolean[nums.length]);
    }

    private boolean dp(int[] nums, int index, Boolean[] memo) {
        if(index >= nums.length - 1) {
            return true;
        } else if (memo[index] != null) {
            return memo[index];
        }

        boolean result = false;
        for(int i = nums[index]; i >= 1 && !result; i--) {
            result = dp(nums, index + i, memo);
        }

        memo[index] = result;
        return result;
    }
}
