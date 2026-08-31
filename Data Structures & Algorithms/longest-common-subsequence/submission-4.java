class Solution {
    // Time: O(m*n)
    // Space: O(m*n)
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n+1][m+1];
        for(int i=n-1; i >= 0; i--) {
            for (int j=m-1; j >= 0; j--) {
                int maxFromPreviousIterations = Math.max(dp[i+1][j], Math.max(dp[i][j+1], dp[i+1][j+1]));
                if(text1.charAt(i) == text2.charAt(j)) {
                    // We can extend it
                    dp[i][j] = Math.max(1 + dp[i+1][j+1], maxFromPreviousIterations);
                } else {
                    dp[i][j] = maxFromPreviousIterations;
                }
            }
        }

        return dp[0][0];
    }
}
