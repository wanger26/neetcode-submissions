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
    public TreeNode convertBST(TreeNode root) {

        // Time: O(n)
        // Space: O(h)
        convertBST(root, 0);

        return root;
    }

    public int convertBST(TreeNode currentNode, int greaterThanValue) {
        if(currentNode == null) {
            return greaterThanValue;
        }

        int newValue = currentNode.val + convertBST(currentNode.right, greaterThanValue);
        currentNode.val = newValue;

        return convertBST(currentNode.left, newValue);
    }
}