class Solution {
    public boolean canPartition(int[] nums) {

        // Time: O(n*t) where t is the sum of the parition
        // Space: O(n*t)
        int totalSum = 0;
        for(int num : nums) {
            totalSum += num;
        }

        if(totalSum % 2 != 0) {
            return false;
        }

        return dp(nums, 0, totalSum / 2, new Boolean[nums.length][totalSum / 2 + 1]);
    }

    private boolean dp(int[] nums, int index, int target, Boolean[][] memo) {
        if(nums.length == index || target < 0) {
            return false;
        } else if (target == 0) {
            return true;
        } else if (memo[index][target] != null) {
            return memo[index][target];
        }

        memo[index][target] = dp(nums, index + 1, target - nums[index], memo) || dp(nums, index + 1, target, memo);
        return memo[index][target];
    }
}
