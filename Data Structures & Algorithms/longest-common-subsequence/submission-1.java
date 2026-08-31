class Solution {

    // Time: O(mn)
    // Space: O(mn)
    public int longestCommonSubsequence(String text1, String text2) {
        Integer[][] memo = new Integer[text1.length()][text2.length()];
        return dp(text1, text2, 0, 0, memo);
    }

    private int dp(String text1, String text2, int text1Index, int text2Index, Integer[][] memo) {
        if(text1Index < 0 || text1Index == text1.length() || text2Index < 0 || text2Index == text2.length()) {
            return 0;
        } else if (memo[text1Index][text2Index] != null) {
            return memo[text1Index][text2Index];
        }

        // Option 1: Both are equal, try and build of both
        int result = 0;
        if(text1.charAt(text1Index) == text2.charAt(text2Index)) {
            result = 1 + dp(text1, text2, text1Index+1, text2Index+1, memo);
        }

        // Option 2: Do not include text1
        result = Math.max(result, dp(text1, text2, text1Index+1, text2Index, memo));

        // Option 3: Do not include text2
        result = Math.max(result, dp(text1, text2, text1Index, text2Index+1, memo));

        // Option 4: Do not include either
        result = Math.max(result, dp(text1, text2, text1Index+1, text2Index+1, memo));

        memo[text1Index][text2Index] = result;
        
        return result;
    }
}
