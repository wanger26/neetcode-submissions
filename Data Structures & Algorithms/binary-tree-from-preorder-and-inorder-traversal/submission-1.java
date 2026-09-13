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
    private int preIndex = 0;
    private int inIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Time: O(n)
        // Space: O(n)
        return dfs(preorder, inorder, Integer.MAX_VALUE);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, int rightLimit) {
        if (preIndex >= preorder.length) {
            return null;
        } else if (inorder[inIndex] == rightLimit) {
            inIndex++;
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIndex]);
        preIndex++;

        root.left = dfs(preorder, inorder, root.val);
        root.right = dfs(preorder, inorder, rightLimit);

        return root;
    }
}
