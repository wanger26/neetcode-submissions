class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<Integer>[] graph = new List[edges.length+1];
        int[] indegree = new int[edges.length+1];

        for(int i=1; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i < edges.length; i++) {
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            graph[node1].add(node2);
            graph[node2].add(node1);
            indegree[node1]++;
            indegree[node2]++;
        }

        Queue<Integer> nonCycleNodes = new LinkedList<>();
        for(int i = 1; i < indegree.length; i++) {
            if(indegree[i] == 1) {
                nonCycleNodes.add(i);
            }
        }

        while(!nonCycleNodes.isEmpty()) {
            int node = nonCycleNodes.poll();

            for(int neighbor : graph[node]) {
                indegree[neighbor]--;
                if(indegree[neighbor] == 1) {
                    nonCycleNodes.add(neighbor);
                }
            }
        }


        for(int i = edges.length-1; i >=0; i--) {
            int node1 = edges[i][0];
            int node2 = edges[i][1];

            if(indegree[node1] >= 2 && indegree[node2] >= 2) {
                return new int[]{node1, node2};
            }
        }

        return null;
    }
}
