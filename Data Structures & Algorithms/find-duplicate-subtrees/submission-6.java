class Solution {

    private Map<String, Integer> idToValue;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        // Time: O(n)
        // Space: O(n)
        this.idToValue = new HashMap<>();
        List<TreeNode> result = new ArrayList<>();
        dfs(root, new HashSet<>(), result);

        return result;
    }

    private int dfs(TreeNode node, Set<Integer> added, List<TreeNode> result) {
        if(node == null) {
            return -1;
        }

        int leftId = dfs(node.left, added, result);
        int rightId = dfs(node.right, added, result);
        String key = leftId + "," + node.val + "," + rightId;

        int newId = idToValue.size();
        Integer existingId = idToValue.putIfAbsent(key, newId);
        if(existingId == null) {
            return newId;
        }

        if(added.add(existingId)) {
            result.add(node);
        }

        return existingId;
    }
}
