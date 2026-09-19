class Solution {
    public int maxProfit(int[] prices) {

        // Time: O(n)
        // Space: O(1)

        int result = 0;
        int buyPrice = -1;
        for(int i=0; i < prices.length - 1; i++) {
            if(prices[i] > prices[i+1] && buyPrice != -1) {
                result += prices[i] - buyPrice;
                buyPrice = -1;
            } else if (prices[i] < prices[i+1] && buyPrice == -1) {
                buyPrice = prices[i];
            }
        }

        if(buyPrice != -1 && prices[prices.length-1] > buyPrice) {
            result += prices[prices.length-1] - buyPrice;
        }

        return result;
    }
}