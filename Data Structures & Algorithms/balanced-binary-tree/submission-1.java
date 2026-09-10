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

 // Time: O(n)
 // Space: O(h) where h is the height of the tree

class Solution {
    public boolean isBalanced(TreeNode root) {
        int height = isBalancedViaHeight(root);

        return height != -1;
    }

    public int isBalancedViaHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = isBalancedViaHeight(root.left);
        int rightHeight = isBalancedViaHeight(root.right);

        if (rightHeight == -1 || leftHeight == -1 || Math.abs(rightHeight - leftHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
