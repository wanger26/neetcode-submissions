class Solution {
    public int maxProfit(int[] prices) {
        
        int length = prices.length;
        int [][] dp = new int[length+1][2];

        for(int i=length - 1; i >= 0 ; i--) {
            for (int buying = 1; buying >= 0; buying--) {

                if (buying == 1) {
                    // Option 1: Buy
                    int buy = dp[i+1][0] - prices[i]; 
                    // Option 2: Hold
                    int hold = dp[i+1][1];

                    dp[i][1] = Math.max(buy, hold);
                } else {
                    // Option 1: Sell
                    int sell = i + 2 < length ? dp[i+2][1] + prices[i] : prices[i]; 
                    // Option 2: Hold
                    int hold = dp[i+1][0];

                    dp[i][0] = Math.max(sell, hold);
                }
            }
        }
        return dp[0][1];
    }
}
