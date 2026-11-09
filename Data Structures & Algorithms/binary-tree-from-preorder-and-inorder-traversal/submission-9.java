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

    private int preorderIndex;
    private int inorderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // Time: O(n)
        // Space: O(n)
        this.preorderIndex = 0;
        this.inorderIndex = 0;
        return buildTree(preorder, inorder, Integer.MAX_VALUE);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int rightLimit) {
        if(inorderIndex == preorder.length || preorderIndex == preorder.length) {
            return null;
        } else if (inorder[inorderIndex] == rightLimit) {
            inorderIndex++;
            return null;
        }

        TreeNode node = new TreeNode(preorder[preorderIndex++]);
        node.left = buildTree(preorder, inorder, node.val);
        node.right = buildTree(preorder, inorder, rightLimit);

        return node;
    }
}
