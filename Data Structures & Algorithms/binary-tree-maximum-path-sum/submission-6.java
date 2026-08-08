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

    // if left and right. Calc max
    // try left and try right. Calc max. 
    public int maxPathSum(TreeNode root) {
        findMaxPath(root);
        return result;
    }

    public int findMaxPath(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftResult = Math.max(0, findMaxPath(node.left));
        int rightResult = Math.max(0, findMaxPath(node.right));

        // Option 1: complete current path
        result = Math.max(result, leftResult + rightResult + node.val);

        // Option 2: extend upwards
        return node.val + Math.max(leftResult, rightResult);
    }
}
