class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, new HashSet<>(), new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] nums, Set<Integer> indexUsed, List<Integer> currentPath, List<List<Integer>> result) {
        if(currentPath.size() == nums.length) {
            result.add(new ArrayList<>(currentPath));
            return;
        }

        for(int i=0; i < nums.length; i++) {

            if(indexUsed.contains(i)) {
                continue;
            }

            indexUsed.add(i);
            currentPath.add(nums[i]);
            backtrack(nums, indexUsed, currentPath, result);
            indexUsed.remove(i);
            currentPath.removeLast();

            // Skip duplicates ahead to avoid starting same seqeunce
            while(i+1 < nums.length && nums[i] == nums[i+1]) {
                i++;
            }
        }
    }
}