class Solution {
    public int jump(int[] nums) {

        // Time: O(n^2)
        // Space: O(n)
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, n);
        dp[n-1] = 0;

        for(int i = n - 2; i >= 0; i--) {
            for(int j = 1; j <= nums[i] && i + j < n; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i+j]);
            }
        }

        return dp[0];
    }
}
