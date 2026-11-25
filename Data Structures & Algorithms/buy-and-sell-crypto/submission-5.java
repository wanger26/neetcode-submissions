class Solution {
    public int maxProfit(int[] prices) {
        // Time: O(n)
        // Space: O(1)
        int result = 0;
        int minBuy = prices[0];

        for(int price : prices) {
            result = Math.max(result, price - minBuy);
            minBuy = Math.min(minBuy, price);
        }

        return result;
    }
}
