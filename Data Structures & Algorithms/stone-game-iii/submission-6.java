class Solution {
    public String stoneGameIII(int[] stoneValue) {

        // Time: O(n)
        // Space: O(n)
        int n = stoneValue.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[n] = 0;

        for(int i=n-1; i >= 0; i--) {
            int currentSum = 0;
            for(int j = 0; j < 3 && i + j < n; j++) {
                currentSum += stoneValue[i+j];
                dp[i] = Math.max(dp[i], currentSum - dp[i+j+1]);
            }
        }

        int diff = dp[0];
        if(diff > 0) {
            return "Alice";
        } else if (diff < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }
}