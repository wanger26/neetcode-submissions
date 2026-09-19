class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        recursive(1, n, k, new ArrayList<>(), result);

        return result;
    }

    private void recursive(int number, int n, int k, List<Integer> currentPath, List<List<Integer>> result) {
        if (currentPath.size() == k) {
            result.add(new ArrayList<>(currentPath));
            return;
        }

        for (int i = number; i <= n; i++) {
            currentPath.add(i);
            recursive(i + 1, n, k, currentPath, result);
            currentPath.removeLast();
        }
    }
}