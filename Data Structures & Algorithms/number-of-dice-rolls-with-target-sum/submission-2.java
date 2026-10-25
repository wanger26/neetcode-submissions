class Solution {

    private static int MODULE = 1000000007;

    public int numRollsToTarget(int n, int k, int target) {
        if(n * k < target) {
            return 0;
        }

        int[][] memo = new int[n+1][target+1];
        for(int i = 0; i <= n; i++) {
            Arrays.fill(memo[i], -1);
        }

        return (int)(dp(n, k, target, memo) % MODULE);
    }

    private int dp(int n, int k, int target, int[][] memo) {
        if (n == 0 && target == 0) {
            return 1;
        } else if (n == 0 || target <= 0) {
            return 0;
        } else if (memo[n][target] != -1) {
            return memo[n][target];
        }

        int result = 0;
        for(int i = 1; i <= k; i++) {
            result = (result + dp(n - 1, k, target - i, memo)) % MODULE;
        }

        memo[n][target] = result;

        return result;
    }

}
