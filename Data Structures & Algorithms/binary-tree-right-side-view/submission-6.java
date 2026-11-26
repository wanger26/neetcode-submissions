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
    public List<Integer> rightSideView(TreeNode root) {

        if(root == null) {
            return new ArrayList<>();
        }

        // Time: O(n)
        // Space: O(w)
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int initalSize = queue.size();
            result.add(queue.peek().val);
            for(int i = 0; i < initalSize; i++) {
                TreeNode node = queue.poll();
                if(node.right != null) {
                    queue.add(node.right);
                }

                if(node.left != null) {
                    queue.add(node.left);
                }
            }
        }

        return result;
    }
}
