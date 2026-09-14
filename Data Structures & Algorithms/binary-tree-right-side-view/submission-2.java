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

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int numberOfNodesAtLevel = queue.size();

            // Add the right most node to result --> queue adds right first, then left.
            result.add(queue.peek().val);

            for(int i=0; i < numberOfNodesAtLevel; i++) {
                TreeNode currentNode = queue.poll();
                
                if(currentNode.right != null) {
                    queue.add(currentNode.right);
                }

                if(currentNode.left != null) {
                    queue.add(currentNode.left);
                }
            }
        }

        return result;
    }
}
