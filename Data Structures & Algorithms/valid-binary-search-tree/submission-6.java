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

// Time: O(n)
// Space: O(h)
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, int leftBoundry, int rightBoundry) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        boolean leafNodeInvalidForRoot = root.left != null && root.left.val >= root.val;
        boolean leftNodeIsNotInRange = root.left != null && (root.left.val <= leftBoundry || root.left.val >= rightBoundry);
        if (leafNodeInvalidForRoot || leftNodeIsNotInRange) {
            return false;
        }

        leafNodeInvalidForRoot = root.right != null && root.right.val <= root.val;
        boolean rightNodeIsNotInRange = root.right != null && (root.right.val <= leftBoundry || root.right.val >= rightBoundry);
        if (leafNodeInvalidForRoot || rightNodeIsNotInRange) {
            return false;
        }

        // Current tree looks good. Check left and rigth tre
        return isValidBST(root.left, leftBoundry, root.val) && isValidBST(root.right, root.val, rightBoundry);
    }
}
