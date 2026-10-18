class Solution {
    public int numEnclaves(int[][] grid) {

        // Time: O(n*m)
        // Space: O(n*m)
        int n = grid.length;
        int m = grid[0].length;

        for(int i=0; i < n; i++) {
            if(grid[i][0] == 1) {
                dfs(grid, i, 0);
            }

            if(grid[i][m-1] == 1) {
                dfs(grid, i, m-1);
            }
        }

        for(int j=0; j < m; j++) {
            if(grid[0][j] == 1) {
                dfs(grid, 0, j);
            }

            if(grid[n-1][j] == 1) {
                dfs(grid, n-1, j);
            }
        }

        int result = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    result++;
                } else if(grid[i][j] == 2) {
                    grid[i][j] = 1;
                }
            }
        }

        return result;
    }

    private void dfs(int[][] grid, int i, int j) {
        if(i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] != 1) {
            return;
        }

        grid[i][j] = 2;
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }
}