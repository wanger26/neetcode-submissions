class Solution {
    // Time: O(n)
    // Space: O(n)
    public int[] productExceptSelf(int[] nums) {
        // 2, 2, 4, 6
        // Pre Sum: 1, 2, 8, 
        int[] preSum = new int[nums.length];
        preSum[0] = 1;
        for(int i=1; i < nums.length; i++) {
            preSum[i] = preSum[i-1] * nums[i-1];
        }

        int[] postSum = new int[nums.length];
        postSum[nums.length-1] = 1;
        for(int i=nums.length-2; i >= 0; i--) {
            postSum[i] = postSum[i+1] * nums[i+1];
        }

        int[] result = new int[nums.length];
        for(int i=0; i < nums.length; i++) {
            result[i] = preSum[i] * postSum[i];
        }

        return result;

    }
}  
