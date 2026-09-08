class Solution {
    // Time: O(n*m)
    // Space: O(n*m)
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        int maxArea = 0;
        for(int x=0; x < grid.length; x++) {
            for(int y=0; y < grid[0].length; y++) {
                if(grid[x][y] == 1 && !seen[x][y]) {
                    maxArea = Math.max(maxArea, dfs(grid, x, y, seen));
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int x, int y, boolean[][] seen) {
        if(x < 0 || x == grid.length || y < 0 || y == grid[0].length || grid[x][y] != 1 || seen[x][y]) {
            return 0;
        }

        seen[x][y] = true;
        int result = 1;
        result += dfs(grid, x-1, y, seen);
        result += dfs(grid, x+1, y, seen);
        result += dfs(grid, x, y-1, seen);
        result += dfs(grid, x, y+1, seen);

        return result;
    }
}
