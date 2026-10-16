class Solution {
    public int minSteps(int n) {
        if(n == 1) {
            return 0;
        }

        return dp(n, 1, 1, new int[n][n]) + 1;
    }

    private int dp(int n, int value, int paste, int[][] memo) {
        if(n == value) {
            return 0;
        } else if (value > n) {
            return Integer.MAX_VALUE;
        } else if (memo[value][paste] != 0) {
            return memo[value][paste];
        }

        // Option 1: Copy and Paste (if possible)
        int copyAndPasteResult = dp(n, value * 2, value, memo);
        if(copyAndPasteResult != Integer.MAX_VALUE) {
            copyAndPasteResult += 2;
        }

        // Option 2: Paste
        int pasteResult = dp(n, value + paste, paste, memo);
        if(pasteResult != Integer.MAX_VALUE) {
            pasteResult++;
        }

        int result = Math.min(copyAndPasteResult, pasteResult);
        memo[paste][value] = result;
        return result;
    }
}
