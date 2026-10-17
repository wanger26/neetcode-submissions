class Solution {
    public long coloredCells(int n) {

        if(n == 1) {
            return 1;
        }
        
        long[] dp = new long[n];
        dp[1] = 1;

        for(int i=2; i < n; i++) {
            dp[i] = dp[i-1] + 2*(i-1) + 1;
        }

        return 2* dp[n-1] + 2*n - 1;

    }
}
