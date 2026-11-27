class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<Integer>[] graph = new List[n + 1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] indegree = new int[n+1];
        for(int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            graph[node1].add(node2);
            graph[node2].add(node1);

            indegree[node1]++;
            indegree[node2]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int node = 1; node <= n; node++) {
            if(indegree[node] == 1) {
                queue.add(node);
            }
        }

        while(!queue.isEmpty()) {
            int node = queue.poll();
            for(int neighbor : graph[node]) {
                indegree[neighbor]--;
                if(indegree[neighbor] == 1) {
                    queue.add(neighbor);
                }
            }
        }

        for(int i = n - 1; i >= 0; i--) {
            int[] edge = edges[i];
            if(indegree[edge[0]] > 1 && indegree[edge[1]] > 1) {
                return edge;
            }
        }

        return null;
    }
}
