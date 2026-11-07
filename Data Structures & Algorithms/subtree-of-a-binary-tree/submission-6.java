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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        // Time: O(n*m)
        // Space: O(n+m)
        if(root == null || subRoot == null) {
            return false;
        }

        if(root.val == subRoot.val && equals(root.left, subRoot.left) && equals(root.right, subRoot.right)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean equals(TreeNode root, TreeNode subRoot) {
        if(root == null || subRoot == null) {
            return root == subRoot;
        } else if (root.val != subRoot.val) {
            return false;
        }

        return equals(root.left, subRoot.left) && equals(root.right, subRoot.right);
    }
}
