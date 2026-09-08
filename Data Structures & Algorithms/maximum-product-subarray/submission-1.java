class Solution {

    // Time: O(n)
    // Space: O(1)
    public int maxProduct(int[] nums) {
        int prefixSum = 1;
        int postfixSum = 1;

        int result = Integer.MIN_VALUE;
        for(int i=0; i < nums.length; i++) {
            prefixSum = nums[i] * (prefixSum == 0 ? 1 : prefixSum);
            postfixSum =  nums[nums.length-i-1] * (postfixSum == 0 ? 1 : postfixSum);

            result = Math.max(result, Math.max(prefixSum, postfixSum)); 
        }

        return result;
    }
}
