class Solution {
    public double myPow(double x, int n) {
        // Time: O(logn)
        // Space: O(1)

        long power = Math.abs((long) n);
        double result = 1;
        while (power > 0) {
            if (power % 2 != 0) {
                result *= x;
            }
            x *= x;
            power /= 2;
        }

        return n < 0 ? 1 / result : result;
    }
}
