class Solution {
    public int maxCoins(int[] nums) {

        int[] newNums = new int[nums.length+2];
        newNums[0] = 1;
        newNums[nums.length+1] = 1;
        for(int i=0; i < nums.length; i++) {
            newNums[i+1] = nums[i];
        }

        int[][] dp = new int[newNums.length][newNums.length];

        return dfs(newNums, 1, newNums.length-2, dp);
    }

    private int dfs(int[] nums, int left, int right, int[][] dp) {
        if(left > right) {
            return 0;
        } else if (dp[left][right] != 0) {
            return dp[left][right];
        }

        int result = 0;
        for(int i=left; i <= right; i++) {
            // If we pop this last then we will go outside the left and right boundries
            // since all others are gone
            int coins = nums[left-1] * nums[i] * nums[right+1];
            coins += dfs(nums, left, i-1, dp) + dfs(nums, i+1, right, dp);
            result = Math.max(result, coins);
        }

        dp[left][right] = result;
        return result;
    }
}
