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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);

        return result;
    }

    private void inorderTraversal(TreeNode currentNode, List<Integer> result) {
        if(currentNode == null) {
            return;
        }

        inorderTraversal(currentNode.left, result);
        result.add(currentNode.val);
        inorderTraversal(currentNode.right, result);
    }
}