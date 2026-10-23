class Solution {
    public int largestIsland(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int result = 0;
        for(int i=0; i < n; i++) {
            for(int j=0; j < m; j++) {
                if(grid[i][j] == 0) {
                    boolean[][] used = new boolean[n][m];
                    int area = dfs(grid, i-1, j, used) 
                    + dfs(grid, i+1, j, used) 
                    + dfs(grid, i, j-1, used) 
                    + dfs(grid, i, j+1, used);
                    result = Math.max(result, 1 + area);
                }
            }
        }

        return result == 0 ? n*m : result;
    }

    private int dfs(int[][] grid, int i, int j, boolean[][] used) {
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == 0 || used[i][j]) {
            return 0;
        }

        used[i][j] = true;

        int result = 1 + dfs(grid, i+1, j, used);
        result += dfs(grid, i-1, j, used);
        result += dfs(grid, i, j+1, used);
        result += dfs(grid, i, j-1, used);

        return result;
    }
}
