class Solution {
    public int lengthOfLIS(int[] nums) {
        // Bottom Up

        int n = nums.length;
        int[] dp = new int[n];
        dp[n-1] = 1;

        int result = dp[n-1];
        for(int i=n-2; i >= 0; i--) {
            dp[i] = 1;
            for (int j=i+1; j < n; j++) {
                if(nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }

        return result;
    }
}
