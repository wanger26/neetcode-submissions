class Solution {
    public int numDecodings(String s) {
        //102
        int[] dp = new int[s.length()+2];
        dp[s.length()] = 1; // If we get to the back, its a valid path

        for(int i=s.length()-1; i >= 0; i--) {
            if(s.charAt(i) == '0') {
                continue;
            }
            dp[i] = dp[i+1];

            if(i+1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) <= '6'))) {
                dp[i] += dp[i+2]; // If we can make a valid letter with the previous char add that prev points as well
            }
        }

        return dp[0];
    }
}
