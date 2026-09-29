class Solution {
    public int[] sortArray(int[] nums) {

        // Time: O(nlogn)
        // Space: O(n)
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if(left >= right) {
            return;
        }

        int middle = (left + right) / 2;
        mergeSort(nums, left, middle);
        mergeSort(nums, middle + 1, right);
        merge(nums, left, middle, right);
    }

    private void merge(int[] nums, int left, int middle, int right) {
        List<Integer> temp = new ArrayList<>();
        int i = left;
        int j = middle + 1;

        while(i <= middle && j <= right) {
            if(nums[i] <= nums[j]) {
                temp.add(nums[i++]);
            } else {
                temp.add(nums[j++]);
            }
        }

        while(i <= middle) {
            temp.add(nums[i++]);
        }

        while(j <= right) {
            temp.add(nums[j++]);
        }

        for(i = left; i <= right; i++) {
            nums[i] = temp.get(i - left);
        }
    }
}