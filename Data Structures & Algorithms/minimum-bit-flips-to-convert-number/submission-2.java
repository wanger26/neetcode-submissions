class Solution {
    public int minBitFlips(int start, int goal) {
        
        // Time: O(1)
        // Space: O(1)
        return Integer.bitCount(start ^ goal);
    }
}
