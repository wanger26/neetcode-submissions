class Solution {
    public int integerBreak(int n) {
        // Time: O(n^2)
        // Space: O(n)

        if(n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        }

        return dfs(n, new Integer[n+1]);
    }

    private int dfs(int currentNumber, Integer[] memo) {
        if (currentNumber == 1) {
            return 1;
        } else if (memo[currentNumber] != null) {
            return memo[currentNumber];
        }

        // Ensure we split the original number at least once
        int result = currentNumber;

        for(int leftValue = 1; leftValue <= currentNumber/2; leftValue++) {
            int value = leftValue * dfs(currentNumber - leftValue, memo);
            result = Math.max(result, value);
        }

        memo[currentNumber] = result;
        return result;
    }
}