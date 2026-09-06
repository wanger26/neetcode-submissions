class Solution {

    // Time: O(n*m) where n is size of coins and m is amount
    // Space: O(n*m) where n is size of coins and m is amount
    public int change(int amount, int[] coins) {
        Integer[][] memo = new Integer[amount+1][coins.length];
        return dp(amount, 0, coins, memo);
    }

    private int dp(int amountLeft, int index, int[] coins, Integer[][] memo) {
        if(amountLeft == 0) {
            return 1;
        } else if (memo[amountLeft][index] != null) {
            return memo[amountLeft][index];
        }

        int result = 0;
        for(int i=index; i < coins.length; i++) {
            int coin = coins[i];
            if(coin <= amountLeft) {
                result += dp(amountLeft - coin, i, coins, memo);
            }
        }

        memo[amountLeft][index] = result;

        return result;
    }
}
