class Solution {
    public int integerBreak(int n) {
        // Time: O(n^2)
        // Space: O(n)
        return dfs(n, n, new Integer[n+1]);
    }

    private int dfs(int originalNumber, int currentNumber, Integer[] memo) {
        if (currentNumber == 1) {
            return 1;
        } else if (memo[currentNumber] != null) {
            return memo[currentNumber];
        }

        // Ensure we split the original number at least once
        int result = originalNumber == currentNumber ? 0 : currentNumber;

        for(int leftValue = 1; leftValue < currentNumber; leftValue++) {
            int value = leftValue * dfs(originalNumber, currentNumber - leftValue, memo);
            result = Math.max(result, value);
        }

        memo[currentNumber] = result;
        return result;
    }
}