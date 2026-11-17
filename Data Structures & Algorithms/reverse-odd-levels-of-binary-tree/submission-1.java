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
    public TreeNode reverseOddLevels(TreeNode root) {

        // Time: O(n)
        // Space: O(w)

        if (root == null) {
            return null;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        int level = 0;

        Stack<Integer> reversedValues = new Stack<>();
        while (!queue.isEmpty()) {
            int levelWidth = queue.size();
            for (int i = 0; i < levelWidth; i++) {
                TreeNode node = queue.poll();

                if (level % 2 == 1) {
                    node.val = reversedValues.pop();
                }

                if (node.left != null) {
                    queue.add(node.left);

                    if (level % 2 == 0) {
                        reversedValues.push(node.left.val);
                    }
                }

                if (node.right != null) {
                    queue.add(node.right);
                    if (level % 2 == 0) {
                        reversedValues.push(node.right.val);
                    }
                }
            }

            level++;
        }

        return root;
    }
}
