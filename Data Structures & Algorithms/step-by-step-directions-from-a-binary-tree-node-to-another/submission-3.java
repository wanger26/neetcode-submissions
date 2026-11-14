class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {

        // Time: O(n)
        // Space: O(n)

        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Map<TreeNode, Character> direction = new HashMap<>();

        TreeNode start = null;
        TreeNode end = null;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if(node.val == startValue) {
                start = node;
            }

            if(node.val == destValue) {
                end = node;
            }

            if(node.left != null) {
                parent.put(node.left, node);
                direction.put(node.left, 'L');
                stack.push(node.left);
            }

            if(node.right != null) {
                parent.put(node.right, node);
                direction.put(node.right, 'R');
                stack.push(node.right);
            }
        }

        Map<TreeNode, Integer> distanceFromStart = new HashMap<>();

        TreeNode current = start;
        int upCount = 0;
        while(current != null) {
            distanceFromStart.put(current, upCount);
            current = parent.get(current);
            upCount++;
        }

        StringBuilder downPathBackward = new StringBuilder();
        current = end;
        while(!distanceFromStart.containsKey(current)) {
            downPathBackward.append(direction.get(current));
            current = parent.get(current);
        }

        StringBuilder result = new StringBuilder();
        result.append("U".repeat(distanceFromStart.get(current)));
        result.append(downPathBackward.reverse());

        return result.toString();

    }
}
