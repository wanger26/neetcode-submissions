class Solution {
    public int numTeams(int[] rating) {
        int increasing = dp(rating, 0, Integer.MIN_VALUE, 3, true);
        int decreasing = dp(rating, 0, Integer.MAX_VALUE, 3, false);

        return increasing + decreasing;
    }
    private int dp(int[] rating, int index, int prevNumber, int needed, boolean increasing) {
        if(needed == 0) {
            return 1;
        } else if (rating.length == index) {
            return 0;
        }

        // Option 1: Skip current number
        int result = dp(rating, index + 1, prevNumber, needed, increasing);

        // Option 2: Add
        if((increasing && prevNumber < rating[index]) || (!increasing && prevNumber > rating[index])) {
            result += dp(rating, index + 1, rating[index], needed - 1, increasing);
        }

        return result;

    }
}
