class Solution {

    // 
    public int change(int amount, int[] coins) {

        int n = coins.length;
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for(int coinIndex = n-1; coinIndex >= 0; coinIndex--) {
            int[] newdp = new int[amount + 1];
            newdp[0] = 1;
            for(int currentAmount = 0; currentAmount <= amount; currentAmount++) {
                if(currentAmount >= coins[coinIndex]) {
                    newdp[currentAmount] = dp[currentAmount] + newdp[currentAmount - coins[coinIndex]];
                }
            }
            dp = newdp;
        }

        return dp[amount];
    }
}
