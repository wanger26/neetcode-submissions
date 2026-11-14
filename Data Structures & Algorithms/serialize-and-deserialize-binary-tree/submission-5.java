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

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder bldr = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int initalSize = queue.size();

            for (int i = 0; i < initalSize; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    bldr.append("#");
                } else {
                    bldr.append(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
                bldr.append(",");
            }
        }

        return bldr.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");

        if (values[0].equals("#")) {
            return null;
        }

        int index = 1;
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (!values[index].equals("#")) {
                node.left = new TreeNode(Integer.parseInt(values[index]));
                queue.add(node.left);
            }

            if (!values[index + 1].equals("#")) {
                node.right = new TreeNode(Integer.parseInt(values[index + 1]));
                queue.add(node.right);
            }

            index += 2;
        }

        return root;
    }
}
