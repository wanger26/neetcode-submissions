class Solution {
    public int minPathSum(int[][] grid) {

        // Time: O(n*m)
        // Time: O(m)
        int n = grid.length; 
        int m = grid[0].length;

        int[] dp = new int[m + 1];
        for(int i=0; i <= m; i++) {
            dp[i] = Integer.MAX_VALUE; 
        }

        for (int i = n-1; i >= 0; i--) {
            int[] newDp = new int[m+1];
            newDp[m] = Integer.MAX_VALUE;

            for (int j = m-1; j >= 0; j--) {
                if (i == n-1 && j == m-1) {
                    newDp[j] = grid[i][j];
                } else {
                    newDp[j] = grid[i][j] + Math.min(dp[j], newDp[j+1]);
                }
            }

            dp = newDp;
        }

        return dp[0];
    }
}