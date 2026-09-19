class Solution {
    public void sortColors(int[] nums) {

        int redPointer = 0;
        int whitePointer = 0;
        int bluePointer = 0;;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                nums[bluePointer++] = 2;
                nums[whitePointer++] = 1;
                nums[redPointer++] = 0;
            } else if (nums[i] == 1) {
                nums[bluePointer++] = 2;
                nums[whitePointer++] = 1;
            } else {
                nums[bluePointer++] = 2;
            }
        }
    }
}