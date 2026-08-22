class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtracking(nums, new ArrayList<>(), 0, result);
        return result;
    }

    private void backtracking(int[] nums, List<Integer> current, int i, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        for(int j = i; j < nums.length; j++) {
            // If we are pointing at different elements but same value --> cause duplicate, must continue
            if(j > i && nums[j] == nums[j-1]) {
                continue;
            }
            // Otherwise add it and recurse
            current.add(nums[j]);
            backtracking(nums, current, j+1, result);
            current.remove(current.size()-1);
        }
    }
}
