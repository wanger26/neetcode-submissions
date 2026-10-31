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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {

        if(root1 == null || root2 == null) {
            return root1 == root2;
        }

        Queue<TreeNode> tree1 = new LinkedList<>();        
        Queue<TreeNode> tree2 = new LinkedList<>();

        tree1.add(root1);
        tree2.add(root2);

        while(!tree1.isEmpty() && !tree2.isEmpty()) {
            int tree1Size = tree1.size();
            int tree2Size = tree2.size();

            if(tree1Size != tree2Size) {
                return false;
            }

            for(int i = 0; i < tree1Size; i++) {
                TreeNode node1 = tree1.poll();
                TreeNode node2 = tree2.poll();

                if(!equals(node1, node2)) {
                    return false;
                }

                if(equals(node1.left, node2.left) && equals(node1.right, node2.right)) {
                    addToQueue(node1, tree1);
                    addToQueue(node2, tree2);
                    continue;
                } else if (equals(node1.left, node2.right) && equals(node1.right, node2.left)) {
                    TreeNode temp = node1.left;
                    node1.left = node1.right;
                    node1.right = temp;
                } else {
                    return false;
                }

                addToQueue(node1, tree1);
                addToQueue(node2, tree2);
            }
        }

        return tree1.isEmpty() && tree2.isEmpty();
    }

    private void addToQueue(TreeNode node, Queue<TreeNode> queue) {
        if(node.left != null) {
            queue.add(node.left);
        }

        if(node.right != null) {
            queue.add(node.right);
        }
    }

    private boolean equals(TreeNode node1, TreeNode node2) {
        if(node1 == null || node2 == null) {
            return node1 == node2;
        }
        return node1.val == node2.val;
    }
}
