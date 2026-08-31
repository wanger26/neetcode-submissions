class Solution {
    // Time: O(m*n)
    // Space: O(Math.min(m,n))
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        if(n < m) {
            return longestCommonSubsequence(text2, text1);
        }

        int[] dp = new int[m+1];
        for(int i=n-1; i >= 0; i--) {
            int[] newDp = new int[m+1];
            for (int j=m-1; j >= 0; j--) {
                if(text1.charAt(i) == text2.charAt(j)) {
                    // We can extend it - do not double count so we grab prev where we picked neither
                    newDp[j] = 1 + dp[j+1];
                } else {
                    newDp[j] = Math.max(dp[j], newDp[j+1]);
                }
            }
            dp = newDp;
        }

        return dp[0];
    }
}
