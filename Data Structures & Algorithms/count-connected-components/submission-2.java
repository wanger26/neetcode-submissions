class Solution {
    public int countComponents(int n, int[][] edges) {

        // Time: O(v+e)
        // Space: O(v+e)
        List<Integer>[] graph = new List[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        boolean[] visited = new boolean[n];
        int result = 0;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(graph, i, visited);
                result++;
            }
        }

        return result;
    }

    private void dfs(List<Integer>[] graph, int index, boolean[] visited) {
        visited[index] = true;
        for(int neighbor : graph[index]) {
            if(visited[neighbor]) {
                continue; 
            }
            visited[neighbor] = true;
            dfs(graph, neighbor, visited);
        }
    }
}
