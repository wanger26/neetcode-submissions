/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

// Time: O(V + E)
// Space: O(V)
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> nodeToClone = new HashMap<>();
        return dfs(node, nodeToClone);
    }

    private Node dfs(Node node, Map<Node, Node> nodeToClone) {
        if (nodeToClone.containsKey(node)) {
            return nodeToClone.get(node);
        }
        Node clone = new Node(node.val);
        nodeToClone.put(node, clone);

        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(dfs(neighbor, nodeToClone));
        }

        return clone;
    }
}