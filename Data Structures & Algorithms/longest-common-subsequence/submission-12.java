class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // text1 = "cat"
        // text2 = "crabt" 
        int n = text1.length();
        int m = text2.length();

        int[][] memo = new int[n][m];
        for(int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        return dp(text1, text2, 0, 0, memo);
    }


    private int dp(String text1, String text2, int index1, int index2, int[][] memo) {
        if(text1.length() == index1 || text2.length() == index2) {
            return 0;
        } else if(memo[index1][index2] != -1) {
            return memo[index1][index2];
        }

        int result = 0;
        if(text1.charAt(index1) == text2.charAt(index2)) {
            result = 1 + dp(text1, text2, index1 + 1, index2 + 1, memo);
        } else {
            // Option 1: Skip index1
            result = dp(text1, text2, index1 + 1, index2, memo);

            // Option 2: Skip index2
            result = Math.max(result, dp(text1, text2, index1, index2 + 1, memo));
        }

        memo[index1][index2] = result;

        return result;
    }
}
