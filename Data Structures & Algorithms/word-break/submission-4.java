class Solution {

    // Time: O(n^2 * L) where L is the length of the sub
    // Space: O(n)
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[s.length()] = true;

        for(int i=s.length()-1; i >= 0; i--) {
            for(String word : wordDict) {
                int length = word.length();
                if(i + length <= s.length() && word.equals(s.substring(i, i+length))) {
                    dp[i] = dp[i+length];
                }

                if(dp[i]) {
                    break;
                }
            }
        }

        return dp[0];
    }
}
