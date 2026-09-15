class Solution {
    public int singleNumber(int[] nums) {

        // Time: O(n)
        // Space: O(1)
        int result = 0;

        for(int num : nums) {
            result ^= num;
        }

        return result;
    }
}
