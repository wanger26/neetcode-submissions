class Solution {
    public int numDistinct(String s, String t) {

        // Time: O(n*m)
        // Space: O(n*m)
        int n = s.length();
        int m = t.length();

        int[][] memo = new int[n][m];
        for(int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        return dp(s, t, 0, 0, memo);
    }

    private int dp(String s, String t, int sIndex, int tIndex, int[][] memo) {
        if(t.length() == tIndex) {
            return 1;
        } else if (s.length() == sIndex) {
            return 0;
        } else if (memo[sIndex][tIndex] != -1) {
            return memo[sIndex][tIndex];
        }

        int result = 0;
        // Option 1: If they match use
        if(s.charAt(sIndex) == t.charAt(tIndex)) {
            result += dp(s, t, sIndex + 1, tIndex+1, memo);
        }

        // Option 2: Do not use
        result += dp(s, t, sIndex + 1, tIndex, memo);


        memo[sIndex][tIndex] = result;

        return result;
    }
}
