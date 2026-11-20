class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        // Time: O(n)
        // Space: O(n^2)
        List<TreeNode> result = new ArrayList<>();
        findDuplicateSubtrees(root, new HashSet<>(), new HashSet<>(), result);
        return result;
    }

    private String findDuplicateSubtrees(TreeNode node, Set<String> subtrees, Set<String> addedSubTrees, List<TreeNode> result) {
        if(node == null) {
            return "null,";
        }

        StringBuilder bldr = new StringBuilder();
        bldr.append(node.val).append(",");
        bldr.append(findDuplicateSubtrees(node.left, subtrees, addedSubTrees, result));
        bldr.append(findDuplicateSubtrees(node.right, subtrees, addedSubTrees, result));

        String subtree = bldr.toString();
        if(subtrees.contains(subtree) && !addedSubTrees.contains(subtree)) {
            result.add(node);
            addedSubTrees.add(subtree);
        } else {
            subtrees.add(subtree);
        }

        return subtree;
    }
}
