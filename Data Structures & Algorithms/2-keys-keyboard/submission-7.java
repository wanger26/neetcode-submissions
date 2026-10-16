class Solution {
    public int minSteps(int n) {

        // Time: O(n^2)
        // Space: O(n)
        int[] dp = new int[n+1];

        for(int value = 2; value <= n; value++) {
            // Option A: Copy and paste value - 1 times
            dp[value] = value;

            for(int previous = 1; previous < value; previous++) {
                if(value % previous == 0) {
                    // Copy previous, then paste value / previous
                    int result = dp[previous] + value / previous;

                    dp[value] = Math.min(dp[value], result);
                }
            }
        }

        return dp[n];
    }
}
