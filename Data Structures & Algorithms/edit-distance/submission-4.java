class Solution {

    // Time: O(n*m) where n is size of word1 and m is size of word2
    // Space: O(n*m)
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n+1][m+1];

        // For all case where word2 was reached, we need to remove remaning characters in word1
        for(int i=0; i < n; i++) {
            dp[i][m] = n-i;
        }

        // For all case where word1 is empty, we need to add remaning characters from word2 into word1
        for(int j=0; j < m; j++) {
            dp[n][j] = m-j;
        }

        for(int i=n-1; i >= 0; i--) {
            for(int j = m-1; j >= 0; j--) {
                if(word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i+1][j+1];
                } else {
                    // If not equal, the answer is the min of if we add, remove or replace the char at word1.
                    dp[i][j] = Math.min(dp[i+1][j], Math.min(dp[i][j+1], dp[i+1][j+1])) + 1;
                }
            }
        }

        return dp[0][0];
    }
}
