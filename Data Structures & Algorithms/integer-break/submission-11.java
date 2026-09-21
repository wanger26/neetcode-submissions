class Solution {
    public int integerBreak(int n) {

        // Time: O(logn)
        // Space: O(1)
        if (n <= 3) {
            return n - 1;
        }

        int result = (int)(Math.pow(3, n/3));
        if(n % 3 == 1) {
            return (result / 3) * 4;
        }

        return result * Math.max(1, n%3);
    }
}