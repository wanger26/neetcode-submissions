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

    private int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        findMaxPath(root);
        return result;
    }

    public int findMaxPath(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Start at 0 because if its negative we dont take it
        int leftResult = Math.max(0, findMaxPath(node.left));
        int rightResult = Math.max(0, findMaxPath(node.right));

        // Check if current complete tree is biggest
        result = Math.max(result, leftResult + rightResult + node.val);

        // Give the largest side to the parent to try and extend
        return node.val + Math.max(leftResult, rightResult);
    }
}
