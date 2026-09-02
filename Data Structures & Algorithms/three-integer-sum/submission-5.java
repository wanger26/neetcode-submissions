class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length-1;

            if(i > 0 && nums[i] == nums[i-1]) {
                continue; // If current character is same as prev, no need to check.
            }
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    // Skip duplicates
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else if(sum < 0) {
                    // Need to increase --> move left
                    left++;
                } else {
                    // Need to decrease --> move right
                    right--;
                }
            }
            
            
        }

        return result;

    }
}
