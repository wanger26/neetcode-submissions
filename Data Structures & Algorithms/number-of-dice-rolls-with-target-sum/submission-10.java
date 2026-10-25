class Solution {

    private static int MODULE = 1000000007;

    public int numRollsToTarget(int n, int k, int target) {
        if (n * k < target) {
            return 0;
        }

        int[][] dp = new int[n+1][target+1];
        dp[0][0] = 1;
        for(int dice = 1; dice <= n; dice++) {
            for(int sum = 1; sum <= target; sum++) {
                for(int face = 1; face <= k; face++) {
                    if(sum >= face) {
                        dp[dice][sum] = (dp[dice][sum] + dp[dice-1][sum - face]) % MODULE;
                    } else {
                        break;
                    }
                }
            }
        }

        return dp[n][target];
    }
}
