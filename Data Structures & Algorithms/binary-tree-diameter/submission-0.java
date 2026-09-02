/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int result;
    public int diameterOfBinaryTree(TreeNode root) {
        this.result = 0;
        dfs(root);

        return this.result;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLength = dfs(root.left);
        int rightLength = dfs(root.right);
        this.result = Math.max(result, leftLength + rightLength);

        return 1 + Math.max(leftLength, rightLength);
    }
}
