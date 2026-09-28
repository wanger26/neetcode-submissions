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
    public TreeNode insertIntoBST(TreeNode root, int val) {

        // Time: O(h)
        // Space: O(h)
        if(root == null) {
            return new TreeNode(val);
        }

        boolean left = false;
        TreeNode parent = null;
        TreeNode current = root;
        while(current != null) {
            parent = current;

            // Go left
            if(val < current.val) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if(val < parent.val) {
            parent.left = new TreeNode(val);
        } else {
            parent.right = new TreeNode(val);
        }

        return root;
    }
}