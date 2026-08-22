// Time: O(n*2^n)
// Space: O(n*2^n)
class Solution {

    private List<List<Integer>> result = new ArrayList<>();

    // Top Down
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        this.result = new ArrayList<>();
        recurse(nums, new ArrayList<>(), 0);
        
        return result;
    }

    private void recurse(int[] nums, List<Integer> current, int index) {
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Option 1: Include
        int insertionIndex = current.size();
        current.add(nums[index]);
        recurse(nums, current, index + 1);
        current.remove(insertionIndex);

        // Option 2: Do not include. Next number must not equal current number
        int nextIndex = index+1;
        for(; nextIndex < nums.length && nums[nextIndex] == nums[index]; nextIndex++) {}
        recurse(nums, current, nextIndex);
    }
}
