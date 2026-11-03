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

    public int maxPathSum(TreeNode root) {

        if(root == null) {
            return 0;
        }

        this.result = Integer.MIN_VALUE;
        getMaxPathSum(root);

        return this.result;
    }

    
    private int getMaxPathSum(TreeNode node) {
        int left = 0;
        if(node.left != null) {
            left = getMaxPathSum(node.left);
        }

        int right = 0;
        if(node.right != null) {
            right = getMaxPathSum(node.right);
        }

        int maxPathSumNotSplitting = Math.max(node.val, node.val + Math.max(left, right));
        this.result = Math.max(result, Math.max(maxPathSumNotSplitting, node.val + left + right));
        
        return maxPathSumNotSplitting;
    }

}
