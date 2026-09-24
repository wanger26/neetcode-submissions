class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, n);
        dp[0] = 0;

        for(int target = 1; target <= n; target++) {
            for(int base = 1; base * base <= target; base++) {
                int pefectSquare = base * base;
                dp[target] = Math.min(dp[target], 1 + dp[target-pefectSquare]);
            }
        }

        return dp[n];
    }
}