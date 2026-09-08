class Solution {

    // Time: O(n!*n)
    // Space: O(n!*n). Where n! is the answer and n is the number of call stacks.

    private List<List<Integer>> result; // O(n!)

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        dp(nums, new boolean[nums.length], new ArrayList<>());
        return result;
    }

    // Space: O(n)
    private void dp(int[] nums, boolean[] used, List<Integer> current) {
        if(current.size() == nums.length) {
            result.add(new ArrayList<>(current)); // O(n)
            return;
        }


        for(int i=0; i < nums.length; i++) {
            if(used[i]) {
                continue;
            }

            used[i] = true;
            current.add(nums[i]);
            dp(nums, used, current);

            used[i] = false;
            current.remove(current.size()-1);
        }
    }
}
