class Solution {

    private char LAND = '1';
    public int numIslands(char[][] grid) {
        boolean[][] explored = new boolean[grid.length][grid[0].length];

        int result = 0;
        for(int i=0; i < grid.length; i++) {
            for(int j=0; j < grid[i].length; j++) {

                if(grid[i][j] == LAND && !explored[i][j]) {
                    dfs(grid, i, j, explored);
                    result++;
                }
            }
        }

        return result;
    }

    private void dfs(char[][] grid, int i, int j, boolean[][] explored) {

        if (i >= grid.length || i < 0 || j < 0 || j >= grid[i].length || explored[i][j] || grid[i][j] != LAND) {
            return;
        }

        explored[i][j] = true;

        dfs(grid, i+1, j, explored);
        dfs(grid, i-1, j, explored);
        dfs(grid, i, j+1, explored);
        dfs(grid, i, j-1, explored);
    }
}
