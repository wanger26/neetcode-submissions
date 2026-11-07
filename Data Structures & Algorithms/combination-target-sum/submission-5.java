class Solution {

    private List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.result = new ArrayList<>();
        Arrays.sort(nums);
        dp(nums, 0, target, new ArrayList<>());

        return result;
    }
    
    private void dp(int[] nums, int index, int target, List<Integer> path) {
        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        } else if (nums.length == index) {
            return;
        }

        for(int i = index; i < nums.length && nums[i] <= target; i++) {
            path.add(nums[i]);
            dp(nums, i, target - nums[i], path);
            path.removeLast();
        }
    }
}
