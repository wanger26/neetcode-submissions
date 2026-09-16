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
        List<String> result = new ArrayList<>();
        serialize(root, result);

        return String.join(",", result);
    }

    private void serialize(TreeNode node, List<String> result) {
        if(node == null) {
            result.add("N");
            return;
        }

        result.add(String.valueOf(node.val));
        serialize(node.left, result);
        serialize(node.right, result);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        int[] index = {0};

        return deserialize(values, index);
    }

    private TreeNode deserialize(String[] values, int[] index) {

        if(values[index[0]].equals("N")) {
            index[0]++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(values[index[0]]));
        index[0]++;

        node.left = deserialize(values, index);
        node.right = deserialize(values, index);

        return node;
    }
}
