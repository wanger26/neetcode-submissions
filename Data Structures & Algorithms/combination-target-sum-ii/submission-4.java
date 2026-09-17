class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int start, int target, List<Integer> currentPath, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(currentPath));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Early pruning: since candidates are sorted, no further elements can sum to target
            if (candidates[i] > target) {
                break;
            }

            // Skip duplicates at the current decision level
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            currentPath.add(candidates[i]);
            backtrack(candidates, i + 1, target - candidates[i], currentPath, result);
            currentPath.removeLast();
        }
    }
}