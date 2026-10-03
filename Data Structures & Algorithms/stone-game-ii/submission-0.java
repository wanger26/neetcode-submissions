class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        Integer[][][] dp = new Integer[2][n][n+1];

        return dp(piles, 0, 0, 1, dp);
    }

    private int dp(int[] piles, int alice, int index, int m, Integer[][][] dp) {
        if(index == piles.length) {
            return 0;
        } else if (dp[alice][index][m] != null) {
            return dp[alice][index][m];
        }

        int result = alice == 0 ? 0 : Integer.MAX_VALUE;
        int total = 0;

        for(int x = 1; x <= 2*m && index + x <= piles.length; x++) {
            total += piles[index + x - 1];
            if(alice == 0) {
                result = Math.max(result, total + dp(piles, 1, index + x, Math.max(x, m), dp));
            } else {
                result = Math.min(result, dp(piles, 0, index + x, Math.max(x, m), dp));
            }
        }

        dp[alice][index][m] = result;

        return result;
    }
}