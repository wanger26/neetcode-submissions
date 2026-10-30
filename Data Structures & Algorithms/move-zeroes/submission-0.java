class Solution {
    public void moveZeroes(int[] nums) {

        // Time: O(n)
        // Time: O(1)
        int insertIndex = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                continue;
            }
            nums[insertIndex] = nums[i];
            insertIndex++;
        }

        while(insertIndex < nums.length) {
            nums[insertIndex++] = 0;
        }
    }
}