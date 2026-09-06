class Solution {

    // 
    public int change(int amount, int[] coins) {

        int n = coins.length;
        Arrays.sort(coins);
        int[][] dp = new int[n+1][amount + 1];

        for(int i=0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for(int coinIndex = n-1; coinIndex >= 0; coinIndex--) {
            for(int currentAmount = 0; currentAmount <= amount; currentAmount++) {
                if(currentAmount >= coins[coinIndex]) {
                    dp[coinIndex][currentAmount] = dp[coinIndex + 1][currentAmount] + dp[coinIndex][currentAmount - coins[coinIndex]];
                }
            }
        }

        return dp[0][amount];
    }
}
