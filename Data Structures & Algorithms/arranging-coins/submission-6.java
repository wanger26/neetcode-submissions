class Solution {
    public int arrangeCoins(int n) {

        // Time: O(logn)
        int left = 1;
        int right = n;

        int result = 0;
        while (left <= right) {
            int rows = left + (right - left) / 2;
            long coinsNeeded = (long) rows * (rows + 1) / 2;
            if (coinsNeeded == n) {
                return rows;
            } else if (coinsNeeded < n) {
                result = rows;
                left = rows + 1;
            } else {
                right = rows - 1;
            }
        }

        return result;
    }
}