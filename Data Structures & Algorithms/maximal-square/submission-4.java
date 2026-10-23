class Solution {
    public int maximalSquare(char[][] matrix) {

        // Time: O(n*m)
        // Space: O(n*m)
        int n = matrix.length;
        int m = matrix[0].length;

        int[] dp = new int[m+1];

        int result = 0;
        for(int i = n-1; i >= 0; i--) {
            int[] newDp = new int[m+1];
            for(int j = m -1; j >= 0; j--) {
                if(matrix[i][j] == '1') {
                    newDp[j] = 1 + Math.min(dp[j], Math.min(newDp[j+1], dp[j+1]));
                    result = Math.max(result, newDp[j]);
                }
            }
            dp = newDp;
        }

        return result * result;
    }
}