class Solution {

    private static final int MUST_SELL = 0;
    private static final int CAN_BUY = 1;

    public int maxProfit(int[] prices) {
        
        int length = prices.length;
        int [][] dp = new int[length+1][2];

        for(int i=length - 1; i >= 0 ; i--) {
            for (int buying = 1; buying >= 0; buying--) {

                if (buying == 1) {
                    // Option 1: Buy
                    int buy = dp[i+1][MUST_SELL] - prices[i]; 
                    // Option 2: Hold
                    int hold = dp[i+1][CAN_BUY];

                    dp[i][1] = Math.max(buy, hold);
                } else {
                    // Option 1: Sell
                    int sell = i + 2 < length ? dp[i+2][CAN_BUY] + prices[i] : prices[i]; 
                    // Option 2: Hold
                    int hold = dp[i+1][MUST_SELL];

                    dp[i][0] = Math.max(sell, hold);
                }
            }
        }
        return dp[0][1];
    }
}
