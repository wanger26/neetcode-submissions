class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = -1;
        for(int i = n - 2; i >= 0 && pivot == -1; i--) {
            if(nums[i] < nums[i+1]) {
                pivot = i;
            }
        }

        if(pivot == -1) {
            reverse(nums, 0, n-1);
            return;
        }

        int minValueIndexBiggerThanPivot = -1;
        int minValueBiggerThanPivot = Integer.MAX_VALUE;
        for(int i = pivot + 1; i < n; i++) {
            if(nums[i] > nums[pivot] && nums[i] < minValueBiggerThanPivot) {
                minValueBiggerThanPivot = nums[i];
                minValueIndexBiggerThanPivot = i;
            }
        }

        int temp = nums[pivot];
        nums[pivot] = minValueBiggerThanPivot;
        nums[minValueIndexBiggerThanPivot] = temp;

        reverse(nums, pivot + 1, n-1);
    }

    private void reverse(int[] nums, int left, int right) {
        while(left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}