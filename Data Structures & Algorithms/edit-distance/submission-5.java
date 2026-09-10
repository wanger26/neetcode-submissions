class Solution {

    // Time: O(n*m) where n is size of word1 and m is size of word2
    // Space: O(m)
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] dp = new int[m+1];
        for(int j=0; j < m; j++) {
            dp[j] = m - j;
        }

        for(int i=n-1; i >= 0; i--) {
            int[] newDp = new int[m+1];
            newDp[m] = n-i;
            for(int j = m-1; j >= 0; j--) {
                if(word1.charAt(i) == word2.charAt(j)) {
                    newDp[j] = dp[j+1];
                } else {
                    // If not equal, the answer is the min of if we add, remove or replace the char at word1.
                    newDp[j] = Math.min(dp[j], Math.min(newDp[j+1], dp[j+1])) + 1;
                }
            }
            dp = newDp;
        }

        return dp[0];
    }
}
