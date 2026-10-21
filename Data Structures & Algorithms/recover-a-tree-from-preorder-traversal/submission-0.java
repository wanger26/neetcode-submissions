class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stack = new Stack<>();
        int index = 0;
        int n = traversal.length();

        while (index < n) {
            // Determine the current node's depth.
            int depth = 0;
            while (index < n && traversal.charAt(index) == '-') {
                depth++;
                index++;
            }

            // Parse the current node's value.
            StringBuilder bldr = new StringBuilder();
            while (index < n && traversal.charAt(index) != '-') {
                bldr.append(traversal.charAt(index++));
            }

            TreeNode node = new TreeNode(Integer.valueOf(bldr.toString()));

            // Pop until the stack represents the current node's parent.
            while (stack.size() > depth) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                TreeNode parent = stack.peek();

                if (parent.left == null) {
                    parent.left = node;
                } else {
                    parent.right = node;
                }
            }

            stack.push(node);
        }

        // The root is at the bottom of the stack.
        while (stack.size() > 1) {
            stack.pop();
        }

        return stack.peek();
    }
}