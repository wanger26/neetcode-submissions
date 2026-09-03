class Solution {
    public int uniquePaths(int m, int n) {

        // 1x1 = 1
        // 2x2 = 2
        // 2*3 = 4

        if(m == 1 || n == 1){
            return 1;
        }

        int[][] dp = new int[n][m];
        for(int i=0; i < n; i++) {
            dp[i][m-1] = 1;
        }

        for(int j=0; j < m; j++) {
            dp[n-1][j] = 1;
        }

        for(int i=n-2; i >= 0; i--) {
            for(int j=m-2; j >= 0; j--) {
                dp[i][j] = dp[i+1][j] + dp[i][j+1]; 
            }
        }
        
        return dp[0][0];
        
    }
}
