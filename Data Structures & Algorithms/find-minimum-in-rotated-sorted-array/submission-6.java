class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1 || nums[0] < nums[nums.length-1]) {
            return nums[0];
        }

        int n = nums.length;
        int left = 0;
        int right = n-1;

        // [3,4,5,6,1,2]
        //        | |

        while(left < right) {
            int pivot = left + (right-left)/2;

            // If we found the split. We are done.
            if(right-left == 1 && nums[left] > nums[right]) {
                return nums[right];
            } else if(nums[left] > nums[pivot]) {
                // Break/inflection point is in the left side. Go left.
                right = pivot;
            } else{
                left = pivot;
            }
        }

        return left;

    }
}
