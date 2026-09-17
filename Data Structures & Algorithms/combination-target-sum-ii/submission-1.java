class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // Time: O(n*2^n)
        // Space: O(n)
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();
        backtracking(candidates, 0, target, new ArrayList<>(), result);

        return result;
    }

    private void backtracking(int[] candidates, int index, int target, List<Integer> currentPath, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(currentPath));
            return;
        } else if (index == candidates.length || target < 0 || candidates[index] > target) {
            return;
        }

        // Option 1: Choose current value
        currentPath.add(candidates[index]);
        backtracking(candidates, index + 1, target - candidates[index], currentPath, result);
        currentPath.removeLast();

        // Option 2: Do not choose current value, and skip any duplicates
        int nonDuplicateIndex = index;
        while (nonDuplicateIndex < candidates.length
            && candidates[index] == candidates[nonDuplicateIndex]) {
            nonDuplicateIndex++;
        }

        backtracking(candidates, nonDuplicateIndex, target, currentPath, result);
    }
}
