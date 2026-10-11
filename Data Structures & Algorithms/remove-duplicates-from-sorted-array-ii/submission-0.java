class Solution {
    public int removeDuplicates(int[] nums) {
        
        int insertIndex = 0;
        int left = 0;
        int right = 0;

        while(right < nums.length) {
            while(right < nums.length && nums[left] == nums[right]) {
                right++;
            }

            for(int i=0; i < Math.min(2, right - left); i++) {
                nums[insertIndex] = nums[left];
                insertIndex++;
            }

            left = right;
        }

        return insertIndex;
    }
}