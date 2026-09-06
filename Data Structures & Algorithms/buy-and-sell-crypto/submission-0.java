class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int currentBuyPrice = prices[0];
        for(int i=1; i < prices.length; i++) {
            if(prices[i] >= currentBuyPrice) {
                maxProfit = Math.max(maxProfit, prices[i] - currentBuyPrice);
            } else {
                currentBuyPrice = prices[i];
            }
        }

        return maxProfit;
    }
}
