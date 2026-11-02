class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {

        // Time: O(n^2)
        // Space: O(n^2)
        int n = scores.length;

        int[][] pairs = new int[n][2];
        for(int i = 0; i < n; i++) {
            pairs[i][0] = scores[i];
            pairs[i][1] = ages[i];
        }

        // Sort by age in increasing order and score in increasing order
        Arrays.sort(pairs, (a,b) -> {
            int result = a[1] - b[1];
            if(result == 0) {
                return a[0] - b[0];
            }
            return result;
        });

        return dp(pairs, 0, -1, new int[n][n+1]);
    }

    private int dp(int[][] pairs, int index, int prevIndex, int[][] memo) {
        if(pairs.length == index) {
            return 0;
        } else if (memo[index][prevIndex+1] != 0) {
            return memo[index][prevIndex+1];
        }

        int result = 0;
        // Option 1: Choose
        if(prevIndex == -1 || pairs[index][0] >= pairs[prevIndex][0]) {
            result = pairs[index][0] + dp(pairs, index + 1, index, memo);
        }

        // Option 2: Do not choose
        result = Math.max(result, dp(pairs, index + 1, prevIndex, memo));

        memo[index][prevIndex+1] = result;

        return result;
    }
}
