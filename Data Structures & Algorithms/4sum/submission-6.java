class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        // Time: O(n^3)
        // Space: O(logn)

        Arrays.sort(nums); // Space: O(logn)
        List<List<Integer>> result = new ArrayList<>();
        nSum(nums, 0, 4, target, new ArrayList<>(), result);

        return result;
    }

    private void nSum(int[] nums, int index, int k, long target, List<Integer> currentPath, List<List<Integer>> result) {

        if (nums.length - index < k) {
            return;
        }

        if(k > 2) {
            for(int i=index; i < nums.length; i++) {

                // Skip duplicates
                if (i > index && nums[i] == nums[i - 1]) {
                    continue;
                }

                currentPath.add(nums[i]);
                nSum(nums, i + 1, k - 1, target - nums[i], currentPath, result);
                currentPath.removeLast();
            }
        } else {
            int left = index;
            int right = nums.length-1;

            while(left < right) {
                long remainder = (long) target - nums[left] - nums[right];

                if(remainder == 0) {
                    currentPath.add(nums[left]);
                    currentPath.add(nums[right]);
                    result.add(new ArrayList<>(currentPath));
                    currentPath.removeLast();
                    currentPath.removeLast();
                    
                    left++;
                    right--;
                    // Skip duplicates
                    while(left < right && nums[left] == nums[left-1]) {
                        left++;
                    }

                    while(left < right && nums[right] == nums[right+1]) {
                        right--;
                    }
                } else if (remainder < 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
    }


}