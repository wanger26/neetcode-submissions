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
        return findAndDelete(root, key);
    }

    private TreeNode findAndDelete(TreeNode currentNode, int key) {
        if (currentNode == null) {
            return null;

        } else if (currentNode.val == key) {
            if (currentNode.right != null) {
                TreeNode minNode = currentNode.right;
                while (minNode.left != null) {
                    minNode = minNode.left;
                }
                currentNode.val = minNode.val;
                currentNode.right = findAndDelete(currentNode.right, minNode.val);
                return currentNode;
            } else if (currentNode.left != null) {
                return currentNode.left;
            } else {
                // Removing a leaf
                return null;
            }
        }

        if (key < currentNode.val) {
            currentNode.left = findAndDelete(currentNode.left, key);
        } else {
            currentNode.right = findAndDelete(currentNode.right, key);
        }

        return currentNode;
    }
}