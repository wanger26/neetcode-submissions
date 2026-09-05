class Solution {

    // Time: O(n)
    // Space: O(n)
    public int numDecodings(String s) {
        Integer[] memo = new Integer[s.length()];
        return dp(s, 0, memo);
    }

    private int dp(String s, int index, Integer[] memo) {
        if(index == s.length()) {
            return 1;
        } else if(index > s.length() || s.charAt(index) == '0') {
            return 0;
        } else if (memo[index] != null) {
            return memo[index];
        }

        // Option 1: Just use the 1 digit
        int result = dp(s, index + 1, memo);

        // Option 2: If current char is 1 we can, if 2 we can so long next char is less than 6
        char currentChar = s.charAt(index);
        if(currentChar == '1' || (currentChar == '2' && index + 1 < s.length() && s.charAt(index+1) <= '6')) {
            result += dp(s, index + 2, memo);
        }

        memo[index] = result;
        return result;
    }
}
