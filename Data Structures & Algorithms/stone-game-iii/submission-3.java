class Solution {
    public String stoneGameIII(int[] stoneValue) {

        // Time: O(n^2)
        // Space: O(n)
        Integer[][] memo = new Integer[2][stoneValue.length];
        int totalStoneValue = 0;
        for(int value : stoneValue) {
            totalStoneValue += value;
        }

        int aliceMaxValue = dp(stoneValue, 0, 0, memo);
        int bobMaxValue = totalStoneValue - aliceMaxValue;

        if(bobMaxValue < aliceMaxValue) {
            return "Alice";
        } else if (aliceMaxValue < bobMaxValue) {
            return "Bob";
        } else {
            return "Tie";
        }
    }

    private int dp(int[] stoneValue, int alice, int index, Integer[][] memo) {
        if(index == stoneValue.length) {
            return 0;
        } else if(memo[alice][index] != null) {
            return memo[alice][index];
        }

        int result = alice == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int currentSum = 0;
        for(int i=0; i < 3 && index + i < stoneValue.length; i++) {
            if(alice == 0) {
                currentSum += stoneValue[index+i];
                result = Math.max(result, currentSum + dp(stoneValue, 1, index + i + 1, memo));
            } else {
                result = Math.min(result, dp(stoneValue, 0, index + i + 1, memo));
            }
        }

        memo[alice][index] = result;
        return result;
    }
}