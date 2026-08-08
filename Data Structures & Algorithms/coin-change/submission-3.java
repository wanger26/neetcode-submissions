class Solution {

    // Assumption Coins are always ordered in increasing order
    public int coinChange(int[] coins, int amount) {
        int result = dp(coins, coins.length - 1, amount, new HashMap<>());
        return result == Integer.MAX_VALUE ? -1 : result;
    }


    private int dp(int[] coins, int coinIndex, int amountLeft, HashMap<Integer, Integer> memo) {

        if (memo.containsKey(amountLeft)) {
            return memo.get(amountLeft);
        }

        if(amountLeft == 0) {
            return 0;
        } else if (coinIndex < 0) {
            return Integer.MAX_VALUE;
        }

        int firstResult = Integer.MAX_VALUE;
        // Option 1: Choose this coin
        if (amountLeft - coins[coinIndex] >= 0) {
            int temp = dp(coins, coinIndex, amountLeft - coins[coinIndex], memo);
            if (temp != Integer.MAX_VALUE) {
                firstResult = 1 + temp;
            }
        }
        // Option 2: Do not choose this coin
        int result = Math.min(firstResult, dp(coins, coinIndex-1, amountLeft, memo));

        memo.put(amountLeft, result);
        return result;
    }
}
