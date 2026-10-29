class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        // Time: O(n)
        // Time: O(k + h)
        List<TreeNode> result = new ArrayList<>();
        Set<Integer> toDelete = new HashSet<>();
        for(int node : to_delete) {
            toDelete.add(node);
        }

        if(root != null && !toDelete.contains(root.val)) {
            result.add(root);
        }

        dfs(root, toDelete, result);

        return result;
    }

    private TreeNode dfs(TreeNode current, Set<Integer> toDelete, List<TreeNode> result) {
        if(current == null) {
            return null;
        }

        if(toDelete.contains(current.val)) {
            if(current.left != null && !toDelete.contains(current.left.val)) {
                result.add(current.left);
            }

            if(current.right != null && !toDelete.contains(current.right.val)) {
                result.add(current.right);
            }

            dfs(current.left, toDelete, result);
            dfs(current.right, toDelete, result);

            return null;
        } else {
            current.left = dfs(current.left, toDelete, result);
            current.right = dfs(current.right, toDelete, result);
        }

        return current;
    }
}
