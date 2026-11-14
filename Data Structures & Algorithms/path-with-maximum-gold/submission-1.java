class Solution {
    public int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int result = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] > 0) {
                    result = Math.max(result, dfs(grid, i, j, new boolean[n][m]));
                }
            }
        }

        return result;
    }

    private int dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }

        visited[i][j] = true;
        int result = dfs(grid, i-1, j, visited);
        result = Math.max(result, dfs(grid, i+1, j, visited));
        result = Math.max(result, dfs(grid, i, j-1, visited));
        result = Math.max(result, dfs(grid, i, j+1, visited));

        visited[i][j] = false;
        return grid[i][j] + result;
    }
}
