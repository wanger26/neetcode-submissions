class Solution {
    public int lastStoneWeightII(int[] stones) {

        // Time: O(m*n) where n is size of stones and m is 1/2 sum 
        // Space: O(m*n) where n is size of stones and m is 1/2 sum
        int sum = 0;
        for(int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }

        int target = sum/2;
        Integer[][] memo = new Integer[stones.length][target+1];
        int bestLeft = dp(stones, 0, 0, target, memo);

        return sum - 2 * bestLeft;
    }

    private int dp(int[] stones, int index, int currentTotal, int target, Integer[][] memo) {
        if(index == stones.length) {
            return currentTotal;
        } else if (memo[index][currentTotal] != null) {
            return memo[index][currentTotal];
        }

        int result = 0;
        // Option 1: Add to current total if does not push us over
        if(currentTotal + stones[index] <= target) {
            result = dp(stones, index+1, currentTotal + stones[index], target, memo);
        }

        // Optiion 2: Do not add to the current total. Get max --> closest to target
        result = Math.max(result, dp(stones, index+1, currentTotal, target, memo));
        memo[index][currentTotal] = result;

        return result;
    }
}