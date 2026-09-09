class Solution {
    // Time: O(n+e)
    // Space: O(n+e)
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i < edges.length; i++) {
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        int result = 0;
        boolean[] explored = new boolean[n];
        for(int i=0; i < n; i++) {
            if(!explored[i]) {
                result++;
                dfs(graph, i, explored);
            }
        }

        return result;
    }

    private void dfs(List<List<Integer>> graph, int node, boolean[] explored) {
        explored[node] = true;
        for(int nextNode : graph.get(node)) {
            if(!explored[nextNode]) {
                dfs(graph, nextNode, explored);
            }
        }
    }
}
