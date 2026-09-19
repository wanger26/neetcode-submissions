class Solution {
    public List<List<Integer>> combine(int n, int k) {
        // Time: O(k!/(k! (n-k)!))
        // Space: O(k)
        List<List<Integer>> result = new ArrayList<>();
        recursive(1, n, k, new ArrayList<>(), result);

        return result;
    }

    private void recursive(int number, int n, int k, List<Integer> currentPath, List<List<Integer>> result) {
        if (currentPath.size() == k) {
            result.add(new ArrayList<>(currentPath));
            return;
        }

        // O(n)
        int limit = n - (k - currentPath.size()) + 1;
        for (int i = number; i <= limit; i++) {
            currentPath.add(i);
            recursive(i + 1, n, k, currentPath, result);
            currentPath.removeLast();
        }
    }
}