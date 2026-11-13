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
    public boolean isCompleteTree(TreeNode root) {

        // Time: O(n)
        // Space: O(n)

        if(root == null) {
            return true;
        }

        int expectedNodes = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {

            boolean expectNoMoreAdditions = false;
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if((node.left == null && node.right != null) || (expectNoMoreAdditions && node.left != null)) {
                    return false;
                }

                if(node.left != null) {
                    queue.add(node.left);
                } else {
                    expectNoMoreAdditions = true;
                }

                if(node.right != null) {
                    queue.add(node.right);
                }
            }

            if(size != expectedNodes && !queue.isEmpty()) {
                return false;
            }

            expectedNodes *= 2;
        }

        return true;
    }
}