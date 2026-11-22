class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] memo = new int[n][m];
        for(int i = 0; i < n; i++) {
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }

        int result = Integer.MAX_VALUE;
        for(int j = 0; j < m; j++) {
            result = Math.min(result, matrix[0][j] + dp(matrix, 1, j, memo));
        }

        return result;
    }

    private int dp(int[][] matrix, int i, int j, int[][] memo) {
        if(i == matrix.length) {
            return 0;
        } else if (memo[i][j] != Integer.MIN_VALUE) {
            return memo[i][j];
        }

        int result = matrix[i][j] + dp(matrix, i+1, j, memo);
        if(j > 0) {
            result = Math.min(result, matrix[i][j-1] + dp(matrix, i+1, j-1, memo));
        }

        if(j + 1 < matrix[i].length) {
            result = Math.min(result, matrix[i][j+1] + dp(matrix, i+1, j+1, memo));
        }

        memo[i][j] = result;
        return result;
    }
}
