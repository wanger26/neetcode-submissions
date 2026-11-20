class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        findDuplicateSubtrees(root, new HashSet<>(), new HashSet<>(), result);
        return result;
    }

    private String findDuplicateSubtrees(TreeNode node, Set<String> subtrees, Set<String> addedSubTrees, List<TreeNode> result) {
        if(node == null) {
            return "null,";
        }

        String subtree = String.valueOf(node.val) + ",";
        subtree += findDuplicateSubtrees(node.left, subtrees, addedSubTrees, result);
        subtree += findDuplicateSubtrees(node.right, subtrees, addedSubTrees, result);

        if(subtrees.contains(subtree) && !addedSubTrees.contains(subtree)) {
            result.add(node);
            addedSubTrees.add(subtree);
        } else {
            subtrees.add(subtree);
        }

        return subtree;
    }
}
