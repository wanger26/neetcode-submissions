class Solution {
    public long minEnd(int n, int x) {
        // Time: O(n)
        // Space: O(1)
        long result = x;
        for(int i = 0; i < n-1; i++) {
            result = (result + 1) | x;
        }

        return result;
    }
}