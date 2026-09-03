class Solution {
    public int missingNumber(int[] nums) {
        
        // [1,2,3]
        // [1,1,2]
        for(int i=0; i < nums.length; i++) {
            if(nums[i] != i && i < nums.length) {
                int pointer = nums[i];
                while(pointer < nums.length && nums[pointer] != pointer) {
                    int temp = nums[pointer];
                    nums[pointer] = pointer;
                    pointer = temp;
                }
            }
        }

        for(int i=0; i < nums.length; i++) {
            if(nums[i] != i) {
                return i;
            }
        }

        return nums.length;
    }
}
