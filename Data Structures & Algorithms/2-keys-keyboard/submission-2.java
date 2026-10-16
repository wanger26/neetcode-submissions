class Solution {
    public int minSteps(int n) {
        if(n == 1) {
            return 0;
        }

        return dp(n, 1, 1) + 1;
    }

    private int dp(int n, int value, int paste) {
        if(n == value) {
            return 0;
        } else if (value > n) {
            return Integer.MAX_VALUE;
        } 

        // Option 1: Copy and Paste (if possible)
        int copyAndPasteResult = dp(n, value * 2, value);
        if(copyAndPasteResult != Integer.MAX_VALUE) {
            copyAndPasteResult += 2;
        }

        // Option 2: Paste
        int pasteResult = dp(n, value + paste, paste);
        if(pasteResult != Integer.MAX_VALUE) {
            pasteResult++;
        }

        int result = Math.min(copyAndPasteResult, pasteResult);

        return result;
    }
}
