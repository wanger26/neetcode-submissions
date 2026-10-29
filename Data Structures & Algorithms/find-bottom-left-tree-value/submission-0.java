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
    public int findBottomLeftValue(TreeNode root) {

        // Time: O(n)
        // Space: O(w)
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int result = -1;
        while(!queue.isEmpty()) {
            int intialSize = queue.size();
            for(int i = 0; i < intialSize; i++) {
                TreeNode node = queue.poll();

                if(i == 0) {
                    result = node.val;
                }

                if(node.left != null) {
                    queue.add(node.left);
                }


                if(node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return result;
    }
}
