class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int i=0; i < edges.length; i++) {
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            if(!graph.containsKey(node1)) {
                graph.put(node1, new HashSet<>());
            }

            if(!graph.containsKey(node2)) {
                graph.put(node2, new HashSet<>());
            }

            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        int result = 0;
        boolean[] explored = new boolean[n];
        for(int i=0; i < n; i++) {
            if(!explored[i]) {
                result++;
                if(!graph.containsKey(i)) {
                    continue;
                } else {
                    dfs(graph, i, explored);
                }
            }
        }

        return result;
    }

    private void dfs(Map<Integer, Set<Integer>> graph, int node, boolean[] explored) {
        if(explored[node]) {
            return;
        }

        explored[node] = true;

        for(int nextNode : graph.get(node)) {
            dfs(graph, nextNode, explored);
        }
    }
}
