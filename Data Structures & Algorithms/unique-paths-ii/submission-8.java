class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Time: O(m*n)
        // Space: O(n)
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        int[] dp = new int[n];
        for (int i = n - 1; i >= 0 && obstacleGrid[m - 1][i] != 1; i--) {
            dp[i] = 1;
        }

        for (int i = m - 2; i >= 0; i--) {
            // Check the rightmost column for the current row
            if (obstacleGrid[i][n - 1] == 1) {
                dp[n - 1] = 0;
            }

            for (int j = n - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0; // Blocked
                } else {
                    dp[j] = dp[j] + dp[j + 1];
                }
            }
        }

        return dp[0];
    }
}