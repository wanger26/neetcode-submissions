class Solution {
    public int longestPalindromeSubseq(String s) {

        // Time: O(n^2)
        // Space: O(n^2)
        int[][] memo = new int[s.length()][s.length()];
        return dp(s, 0, s.length()-1, memo);
    }

    private int dp(String s, int left, int right, int[][] memo) {
        if(left == right) {
            return 1;
        } else if (right < left) {
            return 0;
        } else if(memo[left][right] != 0) {
            return memo[left][right];
        }

        if(s.charAt(left) == s.charAt(right)) {
            return 2 + dp(s, left + 1, right - 1, memo);
        }

        int result = Math.max(dp(s, left + 1, right, memo), dp(s, left, right - 1, memo));
        memo[left][right] = result;

        return result;
    }
}