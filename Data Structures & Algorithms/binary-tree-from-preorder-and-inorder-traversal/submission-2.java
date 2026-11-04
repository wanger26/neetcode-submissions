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
    int preIndex;
    int inIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // Time: O(n)
        // Space: O(n)
        this.preIndex = 0;
        this.inIndex = 0;

        return build(preorder, inorder, Integer.MAX_VALUE);
    }

    private TreeNode build(int[] preorder, int[] inorder, int rightLimit) {
        if(preIndex >= preorder.length) {
            return null;
        } else if (inorder[inIndex] == rightLimit) {
            inIndex++;
            return null;
        }

        TreeNode currentNode = new TreeNode(preorder[preIndex++]);
        currentNode.left = build(preorder, inorder, currentNode.val);
        currentNode.right = build(preorder, inorder, rightLimit);

        return currentNode;
    }
}
