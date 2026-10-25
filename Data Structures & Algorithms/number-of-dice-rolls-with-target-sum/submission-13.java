class Solution {

    private static int MODULE = 1000000007;

    public int numRollsToTarget(int n, int k, int target) {
        // Time: O(n*target*k)
        // Space: O(target)
        if (n * k < target) {
            return 0;
        }

        int[] prev = new int[target+1];
        prev[0] = 1;
        for(int dice = 1; dice <= n; dice++) {
            int[] dp = new int[target+1];
            for(int sum = 1; sum <= target; sum++) {
                for(int face = 1; face <= k; face++) {
                    if(sum >= face) {
                        dp[sum] = (dp[sum] + prev[sum - face]) % MODULE;
                    } else {
                        break;
                    }
                }
            }
            prev = dp;
        }

        return prev[target];
    }
}
