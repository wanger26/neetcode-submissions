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

    private int count;
    public TreeNode convertBST(TreeNode root) {

        this.count = 0;

        // Time: O(n)
        // Space: O(h)
        return createGreaterTree(root);
    }

    public TreeNode createGreaterTree(TreeNode currentNode) {
        if(currentNode == null) {
            return null;
        }

        TreeNode right = createGreaterTree(currentNode.right);
        this.count += currentNode.val;

        TreeNode newNode = new TreeNode();
        newNode.val = count;

        TreeNode left = createGreaterTree(currentNode.left);

        newNode.left = left;
        newNode.right = right;

        return newNode;
    }
}