class Solution {
    public int rangeBitwiseAnd(int left, int right) {

        // Time: O(1)
        // Space: O(1)
        int result = 0;
        while(left != right) {
            left >>= 1;
            right >>= 1;
            result++;
        }

        return left << result;
    }
}