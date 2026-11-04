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

    private TreeNode prev;

    public int minDiffInBST(TreeNode root) {
        this.prev = null;
        return inorder(root);
    }
    
    private int inorder(TreeNode node) {
        if(node == null) {
            return Integer.MAX_VALUE;
        }

        int result = inorder(node.left);
        if(prev != null) {
            result = Math.min(result, node.val - prev.val);
        }
        this.prev = node;

        return Math.min(result, inorder(node.right));
    }
}
