class Solution {

    private List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        this.result = new ArrayList<>();
        backtracking(nums, 0, new ArrayList<>());

        return this.result;
    }

    private void backtracking(int[] nums, int index, List<Integer> current) {
        if(index == nums.length) {
            this.result.add(new ArrayList<>(current));
            return;
        }

        // Option 1: Include
        current.add(nums[index]);
        backtracking(nums, index + 1, current);
        current.removeLast();

        // Option 2: Do not include
        while(index + 1 < nums.length && nums[index] == nums[index+1]) {
            index++;
        }
        backtracking(nums, index + 1, current);
    }
}
