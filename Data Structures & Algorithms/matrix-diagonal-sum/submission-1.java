class Solution {
    public int diagonalSum(int[][] mat) {

        // Time: O(n)
        // Space: O(1)
        int n = mat.length;

        if(n == 1) {
            return mat[0][0];
        }

        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += mat[i][i] + mat[n-i-1][i];
        }

        if(n % 2 == 1) {
            sum -= mat[n/2][n/2];
        }

        return sum;
    }
}