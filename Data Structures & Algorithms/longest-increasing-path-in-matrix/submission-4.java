class Solution {
    // Time: O(m*n)
    // Space: O(m*n)
    public int longestIncreasingPath(int[][] matrix) {
        int result = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] memo = new int[n][m];

        for(int x=0; x < n; x++) {
            for(int y=0; y < m; y++) {
                result = Math.max(result, dfs(matrix, x, y, Integer.MIN_VALUE, memo));
            }
        }

        return result;
    }

    private int dfs(int[][] matrix, int x, int y, int prevValue, int[][] memo) {
        if(x < 0 || x == matrix.length || y < 0 || y == matrix[0].length || matrix[x][y] <= prevValue) {
            return 0;
        } else if (memo[x][y] != 0) {
            return memo[x][y];
        }

        int result = dfs(matrix, x-1, y, matrix[x][y], memo);
        result = Math.max(result, dfs(matrix, x+1, y, matrix[x][y], memo));
        result = Math.max(result, dfs(matrix, x, y-1, matrix[x][y], memo));
        result = Math.max(result, dfs(matrix, x, y+1, matrix[x][y], memo));

        memo[x][y] = result+1;
        return memo[x][y];
    }
}
