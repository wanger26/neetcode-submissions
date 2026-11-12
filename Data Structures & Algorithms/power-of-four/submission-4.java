class Solution {
    public boolean isPowerOfFour(int n) {
        // Time: O(1)
        // Space: O(1)
        return n > 0 && (n & (n-1)) == 0 && (n & 0x55555555) != 0;
    }
}
