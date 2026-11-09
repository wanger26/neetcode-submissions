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

    private int preorderIndex = 0;
    private int inorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, Integer.MAX_VALUE);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int rightLimit) {
        if(inorderIndex == preorder.length || preorderIndex == preorder.length || inorder[inorderIndex] == rightLimit) {
            return null;
        }

        int value = preorder[preorderIndex];
        TreeNode node = new TreeNode(value);
        preorderIndex++;

        node.left = buildTree(preorder, inorder, value);
        inorderIndex++;
        node.right = buildTree(preorder, inorder, rightLimit);

        return node;
    }
}
