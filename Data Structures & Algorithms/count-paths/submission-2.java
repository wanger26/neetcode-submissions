class Solution {

    // Time: O(m*n)
    // Space: O(m*n)
    public int uniquePaths(int m, int n) {

        // 1x1 = 1
        // 2x2 = 2
        // 2*3 = 4

        if(m == 1 || n == 1){
            return 1;
        }

        if(n < m) {
            return uniquePaths(n, m);
        }

        int[] dp = new int[m];
        Arrays.fill(dp, 1);

        for(int i=n-2; i >= 0; i--) {
            int[] newDp = new int[m];
            newDp[m-1] = 1;

            for(int j=m-2; j >= 0; j--) {
                newDp[j] = dp[j] + newDp[j+1]; 
            }
            dp = newDp;
        }
        
        return dp[0];
        
    }
}
