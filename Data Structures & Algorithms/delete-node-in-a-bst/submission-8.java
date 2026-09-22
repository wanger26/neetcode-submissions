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
    public TreeNode deleteNode(TreeNode root, int key) {

        // Time: O(logn)
        // Space: O(1)
        TreeNode parent = null;
        TreeNode currentNode = root;

        while (currentNode != null && currentNode.val != key) {
            parent = currentNode;
            if (key < currentNode.val) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }

        if (currentNode == null) {
            return root;
        }

        if (currentNode.right != null) {
            TreeNode minNodeParent = currentNode;
            TreeNode minNode = currentNode.right;
            while (minNode.left != null) {
                minNodeParent = minNode;
                minNode = minNode.left;
            }
            currentNode.val = minNode.val;

            if(minNodeParent != currentNode) {
                minNodeParent.left = minNode.right;
            } else {
                currentNode.right = minNode.right;
            }
        } else if (parent != null) {
            if (parent.left == currentNode) {
                parent.left = currentNode.left;
            } else {
                parent.right = currentNode.left;
            }
        } else {
            root = currentNode.left;
        }

        return root;
    }
}