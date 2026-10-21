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
    public int widthOfBinaryTree(TreeNode root) {

        root.val = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int result = 0;

        while(!queue.isEmpty()) {
            int minIndex = Integer.MAX_VALUE;
            int maxIndex = Integer.MIN_VALUE;

            int initalSize = queue.size();
            for(int i = 0; i < initalSize; i++) {
                TreeNode node = queue.poll();
                minIndex = Math.min(minIndex, node.val);
                maxIndex = Math.max(maxIndex, node.val);

                if(node.left != null) {
                    node.left.val = node.val * 2;
                    queue.add(node.left);
                }

                if(node.right != null) {
                    node.right.val = node.val * 2 + 1;
                    queue.add(node.right);
                }
            }
            result = Math.max(result, maxIndex - minIndex + 1);
        }

        return result;
    }
}
