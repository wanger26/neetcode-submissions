class Solution {
    public int numDistinct(String s, String t) {
        int[] dp = new int[t.length()+1];
        int[] nextDp = new int[t.length()+1];

        dp[t.length()] = 1;
        nextDp[t.length()] = 1;
        for(int i = s.length()-1; i >= 0; i--) {
            for (int j = t.length()-1; j >= 0; j--) {
                nextDp[j] = dp[j];
                if(s.charAt(i) == t.charAt(j)) {
                    nextDp[j] += dp[j+1]; 
                }
            }
            dp = nextDp.clone();
        }

        return dp[0];
    }
}
