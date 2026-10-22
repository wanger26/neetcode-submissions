class Solution {
    public int paintWalls(int[] cost, int[] time) {

        // Time: O(n*n)
        // Space: O(n*n)
        int n = cost.length;
        return dp(0, cost, time, n, new int[n][n+1]);
    }

    private int dp(int wall, int[] cost, int[] time, int wallsRemaning, int[][] memo) {

        if(wallsRemaning <= 0) {
            return 0;
        } else if(wall == cost.length) {
            return Integer.MAX_VALUE;
        } else if(memo[wall][wallsRemaning] != 0) {
            return memo[wall][wallsRemaning];
        }

        // Option 1: Do not pay for current wall
        int result = dp(wall + 1, cost, time, wallsRemaning, memo);


        // Option 2: Pay for current wall
        int payingForCurrentWall = dp(wall + 1, cost, time, wallsRemaning - time[wall] - 1, memo);
        if(payingForCurrentWall != Integer.MAX_VALUE) {
            payingForCurrentWall += cost[wall];
        }

        result = Math.min(result, payingForCurrentWall);

        memo[wall][wallsRemaning] = result;

        return result;
    }
}
