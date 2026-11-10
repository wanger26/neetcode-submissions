class Solution {
    public int reverseBits(int n) {
        // Time: O(1)
        // Space: O(1)
        int result = 0;
        for(int i = 0; i < 32; i++) {
            result <<= 1;
            result += (n & 1);
            n = n >> 1;
        }

        return result;
    }
}
