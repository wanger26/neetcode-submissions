class Solution {
    public int findMin(int[] nums) {

        // [3,4,5,6,1,2]
        //        | | 

        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            int pivot = (left+right)/2;

            if(nums[left] < nums[right]) {
                return nums[left];
            } else if (nums[pivot] > nums[right]) {
                left = pivot + 1;
            } else {
                right = pivot;
            }
        }

        return nums[left];
        
    }
}
