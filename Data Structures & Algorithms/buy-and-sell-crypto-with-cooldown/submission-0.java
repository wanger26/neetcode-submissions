class Solution {
    public int maxProfit(int[] prices) {

        // Edge Case 1: 1, 2, 3, 100 --> 99
        // Edge Case 2: 4, 3, 2, 1 --> 0
        // Edge Case 3: 1 --> 0
        Map<String, Integer> memo = new HashMap<>();
        return dp(prices, 0, true, memo);
        
    }

    private int dp(int[] prices, int index, boolean canBuy, Map<String, Integer> memo) {
        String key = index + "-" + canBuy;
        if (memo.containsKey(key)) {
            return memo.get(key);
        } else if (index >= prices.length) {
            return 0;
        }

        int result;
        if(canBuy) {
            // Option 1: Buy Today
            int buy = dp(prices, index + 1, false, memo) - prices[index];

            // Option 2: Hold today
            int cool = dp(prices, index + 1, true, memo);

            result = Math.max(buy, cool);
        } else {
            // Option 1: Sell Today - Skip 2 days since you have to hold
            int sold = dp(prices, index + 2, true, memo) + prices[index];

            // Option 2: Hold today
            int cool = dp(prices, index + 1, false, memo);

            result = Math.max(sold, cool);
        }

        memo.put(key, result);
        return result;
    }
}
