class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        // Time: O(n*m)
        // Space: O(m)

        int n = text1.length();
        int m = text2.length();

        int[] dp = new int[m+1];

        for(int i = n-1; i >= 0; i--) {
            int[] newDp = new int[m+1];
            for(int j = m - 1; j >= 0; j--) {
                if(text1.charAt(i) == text2.charAt(j)) {
                    newDp[j] = 1 + dp[j+1];
                } else {
                    newDp[j] = Math.max(newDp[j+1], dp[j]);
                }
            }
            dp = newDp;
        }

        return dp[0];
    }
}
