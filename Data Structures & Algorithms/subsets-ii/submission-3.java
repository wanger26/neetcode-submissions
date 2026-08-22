// Time: O(n*2^n)
// Space: O(n*2^n)
class Solution {

    // Top Down
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return new ArrayList<>(recurse(nums, new ArrayList<>(), 0));
    }

    private List<List<Integer>> recurse(int[] nums, List<Integer> current, int index) {
        if (index == nums.length) {
            return List.of(new ArrayList<>(current));
        }

        // Option 1: Include
        int insertionIndex = current.size();
        current.add(nums[index]);
        List<List<Integer>> result = new ArrayList<>(recurse(nums, current, index + 1));
        current.remove(insertionIndex);

        // Option 2: Do not include. Next number must not equal current number
        int nextIndex = index+1;
        for(; nextIndex < nums.length && nums[nextIndex] == nums[index]; nextIndex++) {}
        result.addAll(recurse(nums, current, nextIndex));

        return result;
    }
}
