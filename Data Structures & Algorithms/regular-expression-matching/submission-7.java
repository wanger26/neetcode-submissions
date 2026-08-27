class Solution {

    // Time: O(n+m)
    // Space: O(n+m)
    public boolean isMatch(String s, String p) {
        Boolean[][] memo = new Boolean[s.length()+1][p.length()+1];
        return dp(s, p, 0, 0, memo);
    }


    private boolean dp(String s, String p, int sIndex, int pIndex, Boolean[][] memo) {
        
        if(pIndex == p.length()) {
            return sIndex == s.length();
        } else if(memo[sIndex][pIndex] != null) {
            return memo[sIndex][pIndex];
        }

        char pChar = p.charAt(pIndex);
        boolean match = sIndex < s.length() && (s.charAt(sIndex) == pChar || pChar == '.');
        Character pNextChar = pIndex + 1 < p.length() ? p.charAt(pIndex+1) : null;

        boolean result = false;
        if(pNextChar != null && pNextChar == '*') {
            // Option 1: Match 0
            result = dp(s, p, sIndex, pIndex + 2, memo);

            // Option 2: Match 1+
            result = result || match && dp(s, p, sIndex + 1, pIndex, memo);
        } else {
            result = match && dp(s, p, sIndex + 1, pIndex + 1, memo);
        } 

        memo[sIndex][pIndex] = result;
        return memo[sIndex][pIndex];
    }
}
