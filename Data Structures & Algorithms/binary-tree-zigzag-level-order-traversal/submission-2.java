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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if(root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean leftToRight = true;
        while(!queue.isEmpty()) {
            int initalSize = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < initalSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                
                if(node.left != null) {
                    queue.add(node.left);
                }

                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            if(!leftToRight) {
                Collections.reverse(level);
            }
            leftToRight = !leftToRight;
            result.add(level);
        }

        return result;
    }
}