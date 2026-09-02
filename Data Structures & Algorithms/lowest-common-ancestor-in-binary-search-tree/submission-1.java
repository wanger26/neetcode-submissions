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

    // Time: O(logH)
    // Space: O(logH)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (q.val < p.val) {
            return lowestCommonAncestor(root, q, p);
        }

        // If p is less than or equal to current and q is greater than root, this must be the root node since p and q will be on left and right of current node
        if(p.val <= root.val && q.val >= root.val) {
            return root;
        }

        // If we did not split p and q with root yet, and p < root. Answer will be on left side
        if(p.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}
