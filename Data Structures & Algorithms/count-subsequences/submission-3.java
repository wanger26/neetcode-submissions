
// Time: O(nm)
// Space: O(nm)
class Solution {

    private int result = 0;

    public int numDistinct(String s, String t) {
        Integer[][] memo = new Integer[s.length()+1][t.length()+1];
        return dp(s, 0, t, 0, memo);
    }

    private int dp(String s, int indexS, String t, int indexT, Integer[][] memo) {

        if (memo[indexS][indexT] != null) {
            return memo[indexS][indexT];
        }
        if (t.length() == indexT) {
            return 1;
        } else if (s.length() == indexS || t.length() == indexT) {
            return 0;
        }

        // Try skipping current one
        int result = dp(s, indexS + 1, t, indexT, memo);

        // Try current one
        if (s.charAt(indexS) == t.charAt(indexT)) {
            result += dp(s, indexS + 1, t, indexT + 1, memo);
        }

        memo[indexS][indexT] = result;
        return result;
    }
}
