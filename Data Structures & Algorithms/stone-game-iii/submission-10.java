class Solution {
    public String stoneGameIII(int[] stoneValue) {

        // Time: O(n)
        // Space: O(1)
        int n = stoneValue.length;
        int[] dp = new int[4];

        for(int i=n-1; i >= 0; i--) {
            int currentSum = 0;
            dp[i % 4] = Integer.MIN_VALUE;
            for(int j = 0; j < 3 && i + j < n; j++) {
                currentSum += stoneValue[i+j];
                dp[i % 4] = Math.max(dp[i % 4], currentSum - dp[(i + j + 1) % 4]);
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