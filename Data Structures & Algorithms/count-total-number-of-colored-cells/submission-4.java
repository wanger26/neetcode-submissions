class Solution {
    public long coloredCells(int n) {
        // Time: O(1)
        // Space: O(1)
        return 1L + 2L * n * (n - 1);
    }
}
