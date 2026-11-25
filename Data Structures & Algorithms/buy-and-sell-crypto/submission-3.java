class Solution {
    public int maxProfit(int[] prices) {
        // Time: O(n)
        // Space: O(1)
        int n = prices.length;
        int[] max = new int[n];
        max[n-1] = prices[n-1];

        for(int i = n - 2; i >= 0; i--) {
            max[i] = Math.max(max[i+1], prices[i]);
        }

        int result = 0;
        for(int i = 0; i < n; i++) {
            result = Math.max(result, max[i] - prices[i]);
        }

        return result;
    }
}
