class Solution {
    public int islandPerimeter(int[][] grid) {

        // Time: O(m+n)
        // Space: O(m+n)
        for(int i=0; i < grid.length; i++) {
            for (int j=0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j, new boolean[grid.length][grid[0].length]);
                }
            }
        }

        return 0;
    }

    private int dfs(int[][] grid, int i, int j, boolean[][] seen) {
        if(i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == 0 || seen[i][j]) {
            return 0;
        }

        seen[i][j] = true;

        int result = 0;
        if(i == 0 || grid[i-1][j] == 0) {
            result++;
        }

        if(i == grid.length - 1 || grid[i+1][j] == 0) {
            result++;
        }

        if(j == 0 || grid[i][j-1] == 0) {
            result++;
        }

        if(j == grid[0].length - 1 || grid[i][j+1] == 0) {
            result++;
        }

        result += dfs(grid, i - 1, j, seen);
        result += dfs(grid, i + 1, j, seen);
        result += dfs(grid, i, j - 1, seen);
        result += dfs(grid, i, j + 1, seen);

        return result;
    }
}