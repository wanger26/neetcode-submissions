class Solution {
    public int climbStairs(int n) {

        // Time: O(n)
        // Space: O(1)
        int prevPrev = 1;
        int prev = 1;
        for(int i = 2; i <= n; i++) {
            int result = prevPrev + prev;
            prevPrev = prev;
            prev = result;
        }

        return prev;
    }
}
