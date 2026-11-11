class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodeIdToNode = new HashMap<>();
        Map<Integer, Integer> nodeToIndegree =  new HashMap<>();

        for(int[] description : descriptions) {
            int parent = description[0];
            int child = description[1];
            boolean isLeft = description[2] == 1;

            TreeNode parentNode = nodeIdToNode.computeIfAbsent(parent, value -> new TreeNode(value));
            TreeNode childNode = nodeIdToNode.computeIfAbsent(child, value -> new TreeNode(value));
            if(isLeft) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }
            nodeToIndegree.put(parent, nodeToIndegree.getOrDefault(parent, 0));
            nodeToIndegree.put(child, nodeToIndegree.getOrDefault(child, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : nodeToIndegree.entrySet()) {
            int nodeId = entry.getKey();
            int value = entry.getValue();

            if(value == 0) {
                return nodeIdToNode.get(nodeId);
            }
        }

        return null;
    }
}
