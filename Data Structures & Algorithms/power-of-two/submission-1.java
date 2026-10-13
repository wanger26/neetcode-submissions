public class Solution {
    public boolean isPowerOfTwo(int n) {
        // Time: O(1)
        // Space: O(1)
        return n > 0 && (n & (n - 1)) == 0;
    }
}