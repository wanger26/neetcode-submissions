class Solution {
    public int missingNumber(int[] nums) {

        // Time: O(n)
        // Space: O(1)
        int n = nums.length;
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }

        return n*(n+1)/2 - sum;
    }
}
