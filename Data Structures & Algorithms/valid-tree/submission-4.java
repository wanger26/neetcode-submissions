class Solution {
    public boolean validTree(int n, int[][] edges) {

        if(edges.length == 0 && n == 1) {
            return true;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            
            if(!graph.containsKey(node1)) {
                graph.put(node1, new ArrayList<>());
            }
            graph.get(node1).add(node2);

            if(!graph.containsKey(node2)) {
                graph.put(node2, new ArrayList<>());
            }
            graph.get(node2).add(node1);
        }

        Set<Integer> visited = new HashSet<>();
        boolean hasNoCycle = dfs(graph, 0, 0, visited);

        return hasNoCycle && visited.size() == n;
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, int currentNode, int parentNode, Set<Integer> visited) {
        if (visited.contains(currentNode)) {
            return false;
        }

        visited.add(currentNode);
        for(int child : graph.get(currentNode)) {
            if(child == parentNode) {
                continue;
            } else if (visited.contains(child)) {
                return false;
            }
            boolean isValid = dfs(graph, child, currentNode, visited);

            if(!isValid) {
                return false;
            }
        }

        return true;
    }
}
