class Solution {
    public int integerBreak(int n) {

        // Time: O(n)
        // Space: O(1)
        if (n <= 3) {
            return n - 1;
        }

        int result = 1;
        while(n > 4) {
            result *= 3;
            n -= 3;
        }

        return result * n;
    }
}