class Solution {
    public int minPathSum(int[][] grid) {
        // Time: O(n*m)
        // Time: O(n*m)
        return dp(grid, 0, 0, new Integer[grid.length][grid[0].length]);
    }

    private int dp(int[][] grid, int i, int j, Integer[][] memo) {

        if(i == grid.length-1 && j == grid[0].length-1) {
            return grid[i][j];
        } else if (i == grid.length || j == grid[0].length) {
            return Integer.MAX_VALUE;
        } else if (memo[i][j] != null) {
            return memo[i][j];
        }
        
        int right = dp(grid, i+1, j, memo);
        int down = dp(grid, i, j+1, memo);
        
        int result = grid[i][j] + Math.min(right, down);
        memo[i][j] = result;

        return result;
    }
}