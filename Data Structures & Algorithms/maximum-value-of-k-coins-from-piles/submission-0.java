class Solution {
    public int maxValueOfCoins(int[][] piles, int k) {

        // Time: O(nk)
        // Space: O(nk)
        int[][] memo = new int[piles.length][k+1];
        for(int i=0; i < piles.length; i++) {
            for (int j = 0; j <= k; j++) {
                memo[i][j] = -1;
            }
        }
        int[] indexs = new int[piles.length];
        return dp(piles, 0, k, memo);
    }

    private int dp(int[][] piles, int pile, int k, int[][] memo) {
        if (k == 0 || pile == piles.length) {
            return 0;
        } else if(memo[pile][k] != -1) {
            return memo[pile][k];
        }

        // Option 1: Go to next pile
        int result = dp(piles, pile + 1, k, memo);

        // Option 2: Pick from current pill 1, max coins
        int currentValue = 0;
        int maxCoinsFromCurrentPile = Math.min(k, piles[pile].length);
        for(int i=0; i < maxCoinsFromCurrentPile; i++) {
            currentValue += piles[pile][i];
            result = Math.max(result, currentValue + dp(piles, pile + 1, k - i - 1, memo));
        }

        memo[pile][k] = result;
        return result;
    }
}
