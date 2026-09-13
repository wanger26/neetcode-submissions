class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // Time: O(n)
        // Space: O(n)
        Integer[] memo = new Integer[cost.length];
        return Math.min(minCostClimbingStairs(cost, 0, memo), minCostClimbingStairs(cost, 1, memo));
    }

    private int minCostClimbingStairs(int[] cost, int index, Integer memo[]) {
        if (index >= cost.length) {
            return 0;
        } else if (memo[index] != null) {
            return memo[index];
        }

        memo[index] = cost[index] + Math.min(minCostClimbingStairs(cost, index + 1, memo), minCostClimbingStairs(cost, index + 2, memo));

        return memo[index];
    }
}
