class Solution {
    public int numTeams(int[] rating) {

        // Time: O(n^2)
        // Space: O(n^2)
        int n = rating.length;
        int[][][] dp1 = new int[n][n + 1][4];
        int[][][] dp2 = new int[n][n + 1][4];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                Arrays.fill(dp1[i][j], -1);
                Arrays.fill(dp2[i][j], -1);
            }
        }

        int increasing = dp(rating, 0, -1, 3, true, dp1);
        int decreasing = dp(rating, 0, -1, 3, false, dp2);

        return increasing + decreasing;
    }

    private int dp(
        int[] rating, int index, int prevIndex,
        int needed, boolean increasing, int[][][] memo
    ) {
        if (needed == 0) {
            return 1;
        }

        if (index == rating.length) {
            return 0;
        }

        int prevState = prevIndex + 1;

        if (memo[index][prevState][needed] != -1) {
            return memo[index][prevState][needed];
        }

        // Option 1: Skip current number
        int result = dp(
            rating, index + 1, prevIndex, needed, increasing, memo
        );

        // Option 2: Select current number if it preserves the ordering
        if (prevIndex == -1
            || (increasing && rating[prevIndex] < rating[index])
            || (!increasing && rating[prevIndex] > rating[index])) {

            result += dp(rating, index + 1, index, needed - 1, increasing, memo);
        }

        memo[index][prevState][needed] = result;
        return result;
    }
}