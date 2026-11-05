class Solution {
    public boolean canJump(int[] nums) {
        
        // Time: O(n*m) where m is the largest jump
        // Space: O(n)
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[n-1] = true;

        for (int i = n-1; i >= 0; i--) {
            for(int j = nums[i]; j >= 1 && !dp[i]; j--) {
                dp[i] = dp[Math.min(n-1, i + j)];
            }
        }

        return dp[0];
    }
}
