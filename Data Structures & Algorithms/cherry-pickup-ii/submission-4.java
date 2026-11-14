class Solution {

    public int cherryPickup(int[][] grid) {

        // Time: O(n*m^2)
        // Space: O(n*m^2)
        int n = grid.length;
        int m = grid[0].length;
        int[][][] memo = new int[n][m][m];

        for (int[][] layer : memo) {
            for (int[] state : layer) {
                Arrays.fill(state, -1);
            }
        }

        return dp(grid, 0, 0, m - 1, memo);
    }

    // Maximum cherries from `row` onward,
    // with robots currently at (row, col1) and (row, col2).
    private int dp(int[][] grid, int row, int col1, int col2, int[][][] memo) {
        if (row == grid.length || col1 < 0 || col1 == grid[0].length || col2 < 0 || col2 == grid[0].length) {
            return 0;
        }

        if (memo[row][col1][col2] != -1) {
            return memo[row][col1][col2];
        }

        int cherries = grid[row][col1];

        // Count a shared cell only once.
        if (col1 != col2) {
            cherries += grid[row][col2];
        }

        int bestNext = 0;

        // Try every pair of next moves: 3 choices per robot = 9 combinations.
        for (int move1 = -1; move1 <= 1; move1++) {
            for (int move2 = -1; move2 <= 1; move2++) {
                bestNext = Math.max(bestNext, dp(grid, row + 1, col1 + move1, col2 + move2, memo));
            }
        }

        memo[row][col1][col2] = cherries + bestNext;
        return memo[row][col1][col2];
    }
}