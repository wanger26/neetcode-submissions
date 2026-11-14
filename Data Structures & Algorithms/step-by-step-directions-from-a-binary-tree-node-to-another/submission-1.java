class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Map<TreeNode, Character> directionFromParent = new HashMap<>();

        TreeNode start = null;
        TreeNode dest = null;

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node.val == startValue) start = node;
            if (node.val == destValue) dest = node;

            if (node.left != null) {
                parent.put(node.left, node);
                directionFromParent.put(node.left, 'L');
                stack.push(node.left);
            }

            if (node.right != null) {
                parent.put(node.right, node);
                directionFromParent.put(node.right, 'R');
                stack.push(node.right);
            }
        }

        // Distance from start to every ancestor.
        Map<TreeNode, Integer> startAncestors = new HashMap<>();
        TreeNode curr = start;
        int upMoves = 0;

        while (curr != null) {
            startAncestors.put(curr, upMoves++);
            curr = parent.get(curr);
        }

        // Walk destination upward until reaching start's first shared ancestor.
        StringBuilder downMovesReversed = new StringBuilder();
        curr = dest;

        while (!startAncestors.containsKey(curr)) {
            downMovesReversed.append(directionFromParent.get(curr));
            curr = parent.get(curr);
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < startAncestors.get(curr); i++) {
            result.append('U');
        }

        return result.append(downMovesReversed.reverse()).toString();
    }
}