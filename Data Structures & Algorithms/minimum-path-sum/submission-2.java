class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length; 
        int m = grid[0].length;

        int[][] dp = new int[n + 1][m + 1];
        for(int i=0; i <= n; i++) {
            dp[i][m] = Integer.MAX_VALUE; 
        }

        for(int j=0; j <= m; j++) {
            dp[n][j] = Integer.MAX_VALUE; 
        }

        for (int i = n-1; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--) {
                if (i == n-1 && j == m-1) {
                    dp[i][j] = grid[i][j];
                } else {
                    dp[i][j] = grid[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
                }
            }
        }

        return dp[0][0];
    }
}