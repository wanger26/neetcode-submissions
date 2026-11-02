class Solution {
    public int minDays(int[][] grid) {
        // Time: O((n*m)^2)
        // Space: O(n*m)
        int n = grid.length;
        int m = grid[0].length;

        if (numberOfIslands(grid) != 1) {
            return 0;
        }

        // Try only removing 1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    int numberOfIslands = numberOfIslands(grid);
                    if (numberOfIslands != 1) {
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }

        return 2;
    }

    private int numberOfIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int numberOfIslands = 0;
        boolean[][] seen = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!seen[i][j] && grid[i][j] == 1) {
                    dfs(grid, i, j, seen);
                    numberOfIslands++;
                }
            }
        }

        return numberOfIslands;
    }

    private void dfs(int[][] grid, int i, int j, boolean[][] seen) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == 0
            || seen[i][j]) {
            return;
        }

        seen[i][j] = true;
        dfs(grid, i - 1, j, seen);
        dfs(grid, i + 1, j, seen);
        dfs(grid, i, j - 1, seen);
        dfs(grid, i, j + 1, seen);
    }
}
