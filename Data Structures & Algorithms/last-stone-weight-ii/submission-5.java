class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;

        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += stones[i];
        }

        int target = sum/2;

        int[][] dp = new int[n+1][target + 1];

        for(int i=1; i <= n; i++) {
            int currentStone = stones[i - 1];
            for(int weight=0; weight <= target; weight++) {

                // Option 1: Exclude the current stone
                dp[i][weight] = dp[i-1][weight];

                // Option 2: Include the current stone
                if(currentStone <= weight) {
                    dp[i][weight] = Math.max(dp[i][weight], currentStone + dp[i-1][weight - currentStone]);
                }
            }
        }


        return sum - 2 * dp[n][target];
    }
}