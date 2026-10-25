class Solution {
    public int minKBitFlips(int[] nums, int k) {

        // Time: O(n*k)
        // Space: O(1)

        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                if(i + k > nums.length) {
                    return -1;
                }
                result++;
                for(int j = 0; j < k; j++) {
                    if(nums[i+j] == 1) {
                        nums[i+j] = 0;
                    } else {
                        nums[i+j] = 1;
                    }
                }
            }
        }

        return result;
    }
}
