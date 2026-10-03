class Solution {
    public String stoneGameIII(int[] stoneValue) {

        // Time: O(n)
        // Space: O(n)
        int diff = dp(stoneValue, 0, new Integer[stoneValue.length]);

        if(diff > 0) {
            return "Alice";
        } else if (diff < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }

    private int dp(int[] stoneValue, int index, Integer[] memo) {
        if(index == stoneValue.length) {
            return 0;
        } else if(memo[index] != null) {
            return memo[index];
        }

        int maxDiff = Integer.MIN_VALUE;
        int currentSum = 0;

        for(int i=0; i < 3 && index + i < stoneValue.length; i++) {
            currentSum += stoneValue[index+i];
            maxDiff = Math.max(maxDiff, currentSum - dp(stoneValue, index + i + 1, memo));
        }

        memo[index] = maxDiff;
        return maxDiff;
    }
}