class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();

        if (s.charAt(n - 1) == '1') {
            return false;
        }

        boolean[] dp = new boolean[n];
        dp[0] = true;

        for (int i = 0; i < n; i++) {
            if (dp[i]) {
                for (int jump = minJump; jump <= maxJump && i + jump < n; jump++) {
                    if (s.charAt(i+jump) == '0') {
                        dp[i+jump] = true;
                    }
                }
            }
        }

        return dp[n-1];
    }
}