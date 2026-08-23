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

 //             3
 //     4               5
 //   1   nukk


// Time: O(N*M)
// Space: O(N+M)
class Solution {  
    // Time: O(N)
    // Space: O(N)
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if(subRoot == null) {
            return true;
        }

        if(root == null) {
            return false;
        }

        if(sameTree(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // Time: O(M)
    // Space: O(M)
    private boolean sameTree(TreeNode root, TreeNode subRoot) {
        if(root == null || subRoot == null) {
            return root == subRoot;
        }

        boolean result = false;
        // If current root is same as subroot val. Could be subtree
        if(root.val == subRoot.val) {
            result = sameTree(root.left, subRoot.left) && sameTree(root.right, subRoot.right);
        }
        return result;
    }
}
