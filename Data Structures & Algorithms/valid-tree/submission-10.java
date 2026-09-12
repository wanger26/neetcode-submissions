class Solution {
    // Time: O(n)
    // Space: O(n)
    public boolean validTree(int n, int[][] edges) {

        // A valid tree has excactly n-1 edges. If it has more it must not be connected or have a cycle
        // With n-1 edges are still need to check for connectivity though.
        if(edges.length != n-1) {
            return false;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        Set<Integer> visited = new HashSet<>();
        dfs(graph, 0, 0, visited);

        return visited.size() == n;
    }

    private void dfs(Map<Integer, List<Integer>> graph, int currentNode, int parentNode, Set<Integer> visited) {
        if (visited.contains(currentNode)) {
            return;
        }

        visited.add(currentNode);
        for(int child : graph.get(currentNode)) {
            if(child == parentNode) {
                continue;
            } else if (visited.contains(child)) {
                return;
            }
            dfs(graph, child, currentNode, visited);
        }
    }
}
