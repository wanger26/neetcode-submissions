class Solution {

    private List<List<Integer>> result;

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        // Time: O(2^n)
        // Space: O(n)
        this.result = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(nums, 0, new ArrayList<>());

        return result;
    }

    private void backtracking (int[] nums, int index, List<Integer> current) {
        if(nums.length == index) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Option 1: Add to current
        current.add(nums[index]);
        backtracking(nums, index + 1, current);
        current.removeLast();

        // Option 2: Do not add to current
        while(index + 1 < nums.length && nums[index] == nums[index+1]) {
            index++;
        }
        backtracking(nums, index + 1, current);

    }
}
