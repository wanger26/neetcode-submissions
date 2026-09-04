class Solution {
    private Integer result;
    private int count; // Track how many nodes we have visited globally

    public int kthSmallest(TreeNode root, int k) {
        result = null;
        count = 0;
        inOrder(root, k);
        return result;
    }

    private void inOrder(TreeNode node, int k) {
        // Base case: if node is null or we already found our answer, stop.
        if (node == null || result != null) {
            return;
        }

        // 1. Traverse Left
        inOrder(node.left, k);

        // 2. Process Current Node
        count++; // We are visiting this node in order
        if (count == k) {
            result = node.val; // Store the node's actual value
            return; // Exit early
        }

        // 3. Traverse Right
        inOrder(node.right, k);
    }
}