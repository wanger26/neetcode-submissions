class Solution {
    public int maximalSquare(char[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;
        int[][] memo = new int[n][m];

        int result = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == '1' && memo[i][j] == 0) {
                    result = Math.max(result, dp(matrix, i, j, memo));
                }
            }
        }

        return result * result;
    }


    private int dp(char[][] matrix, int i, int j, int[][] memo) {
        if(i == matrix.length || j == matrix[0].length || matrix[i][j] == '0') {
            return 0;
        } else if(memo[i][j] != 0) {
            return memo[i][j];
        }

        int right = dp(matrix, i, j+1, memo);
        if(right == 0) {
            memo[i][j] = 1;
            return 1;
        }
        int bottom = dp(matrix, i+1, j, memo);
        if(bottom == 0) {
            memo[i][j] = 1;
            return 1;
        }
        int diagonal = dp(matrix, i+1, j+1, memo);
        if(diagonal == 0) {
            memo[i][j] = 1;
            return 1;
        }

        memo[i][j] = 1 + Math.min(right, Math.min(bottom, diagonal));

        return memo[i][j];
    }
}