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
    public int goodNodes(TreeNode root) {
        // Time: O(n)
        // Space: O(n)
        return dfs(root, Integer.MIN_VALUE);
    }

    public int dfs(TreeNode node, int largestValueFromRoot) {

        if(node == null) {
            return 0;
        }

        int result = node.val >= largestValueFromRoot ? 1 : 0;
        result += dfs(node.left, Math.max(node.val, largestValueFromRoot));
        result += dfs(node.right, Math.max(node.val, largestValueFromRoot));

        return result;
    }
}
