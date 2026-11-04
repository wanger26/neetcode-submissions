class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int result = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '1') {
                    result++;
                    dfs(grid, i, j);
                }
            }
        }

        for(int i = 0; i < n && result > 0; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '2') {
                    grid[i][j] = '1';
                }
            }
        }

        return result;
    }

    private void dfs(char[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] != '1') {
            return;
        }

        grid[i][j] = '2';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
