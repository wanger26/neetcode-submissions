class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] memo = new int[n][m];
        for(int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        int result = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                result = Math.max(result, dp(matrix, i, j, Integer.MIN_VALUE, memo));
            }
        }

        return result;
    }

    private int dp(int[][] matrix, int i, int j, int prevVal, int[][] memo) {
        if(i < 0 || i == matrix.length || j < 0 || j == matrix[0].length || matrix[i][j] <= prevVal) {
            return 0;
        } else if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int result = dp(matrix, i-1, j, matrix[i][j], memo);
        result = Math.max(result, dp(matrix, i+1, j, matrix[i][j], memo));
        result = Math.max(result, dp(matrix, i, j-1, matrix[i][j], memo));
        result = Math.max(result, dp(matrix, i, j+1, matrix[i][j], memo));
        result++;

        memo[i][j] = result;
        return result;
    }
}
