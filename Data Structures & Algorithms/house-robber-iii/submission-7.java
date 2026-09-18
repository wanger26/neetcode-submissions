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
    public int rob(TreeNode root) {
        // Time: O(n)
        // Space: O(h)
        int[] result = dp(root);
        return Math.max(result[0], result[1]);
    }

    // Index --> 0=robbing, 1=not robbing
    private int[] dp(TreeNode currentNode) {
        if(currentNode == null) {
            return new int[]{0,0};
        }

        int[] left = dp(currentNode.left);
        int[] right = dp(currentNode.right);

        int[] current = new int[2];

        int childrenRobbingMax = Math.max(left[0], right[0]);

        // Option 1: Rob current
        current[0] = left[1] + right[1] + currentNode.val;

        // Option 2: Do not rob current.
        int leftMax = Math.max(left[0], left[1]);
        int rightMax = Math.max(right[0], right[1]);
        current[1] = leftMax + rightMax;

        return current;
    }
}