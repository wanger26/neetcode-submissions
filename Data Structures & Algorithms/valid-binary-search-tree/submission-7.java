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

// Time: O(n) - We visit every node exactly once
// Space: O(h) - Where h is the height of the tree (O(n) worst case, O(log n) best case)
class Solution {
    public boolean isValidBST(TreeNode root) {
        // Use Long to prevent overflow/edge case issues with Integer limits
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long minBound, long maxBound) {
        if (root == null) {
            return true;
        }

        // Check if the current node violates the constraints
        if (root.val <= minBound || root.val >= maxBound) {
            return false;
        }

        // Recurse left (updating max limit) and right (updating min limit)
        return isValidBST(root.left, minBound, root.val) && 
               isValidBST(root.right, root.val, maxBound);
    }
}
