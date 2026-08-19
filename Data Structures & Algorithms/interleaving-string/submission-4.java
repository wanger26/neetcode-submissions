class Solution {
    // aaaa         bbbb        aabbbbaa
    //   |             |             |


    // Time: O(mxn) 
    // Space: O(mxn) 
    public boolean isInterleave(String s1, String s2, String s3) {

        if (s1.length() + s2.length() != s3.length()){
            return false;
        }

        Boolean[][] memo = new Boolean[s1.length()+1][s2.length()+1];
        return dp(s1, s2, s3, 0, 0, memo);
    }

    private boolean dp(String s1, String s2, String s3, int index1, int index2, Boolean[][] memo) {
        int index3 = index1 + index2;

        if (index1 == s1.length() && index2 == s2.length() && index3 == s3.length()) {
            return true;
        } else if (memo[index1][index2] != null) {
            return memo[index1][index2];
        }

        boolean result = false;
        if (index1 < s1.length() && index3 < s3.length()) {
            // If s1 can be used go further
            if (s1.charAt(index1) == s3.charAt(index3)) {
                result = dp(s1, s2, s3, index1 + 1, index2, memo);
            }
        }

        if (index2 < s2.length() && !result && index3 < s3.length()) {
            // If s2 can be used go further
            if (s2.charAt(index2) == s3.charAt(index3)) {
                result = dp(s1, s2, s3, index1, index2 + 1, memo);
            }
        }

        memo[index1][index2] = result;
        return result;
    }
}
