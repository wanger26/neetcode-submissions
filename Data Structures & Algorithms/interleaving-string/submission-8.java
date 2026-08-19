class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        } else if (s1.length() > s2.length()) {
            return isInterleave(s2, s1, s3);
        }

        boolean[] dp = new boolean[s2.length()+1];

        for (int i = s1.length(); i >= 0; i--) {
            boolean[] nextDp = new boolean[s2.length()+1];

            for (int j = s2.length(); j >= 0; j--) {
                int s3Index = i + j;

                if (i == s1.length() && j == s2.length()) {
                    nextDp[j] = true;
                    continue;
                }

                if (j < s2.length() && s2.charAt(j) == s3.charAt(s3Index) && nextDp[j+1]) {
                    nextDp[j] = true;
                }

                if (i < s1.length() && s1.charAt(i) == s3.charAt(s3Index) && dp[j]) {
                    nextDp[j] = true;
                }
            }
            dp = nextDp;
        }

        return dp[0];
    }
}
