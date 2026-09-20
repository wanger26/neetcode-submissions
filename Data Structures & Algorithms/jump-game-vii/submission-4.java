class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        // Time: O()
        // Space: 
        int n = s.length();

        if(s.charAt(n-1) == '1') {
            return false;
        }

        boolean[] dp = new boolean[n];
        dp[n-1] = true;

        for(int i = n-1; i >= 0; i--) {
            if(s.charAt(i) == '0') {
                for(int jump = Math.min(maxJump, n-1-i); jump >= minJump && dp[i] == false; jump--) {
                    dp[i] = dp[i + jump];
                }
            }
        }

        return dp[0];
    }
}