class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // Time: O(n+e)
        // Space: O(e + n)

        if(n == 1) {
            return List.of(0);
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        int[] degree = new int[n];

        for(int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            degree[node1]++;
            degree[node2]++;
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            // If we are leaf, add to list to process
            if(degree[i] == 1) {
                queue.add(i);
            }
        }

        int nodesToProcess = n;
        while(!queue.isEmpty() && queue.size() < nodesToProcess) {
            int sizeAtLevel = queue.size();
            nodesToProcess -= sizeAtLevel;
            for(int i=0; i < sizeAtLevel; i++) {
                int node = queue.poll();
                for(int neighbor : graph.get(node)) {
                    if(neighbor == node) {
                        continue;
                    }
                    degree[neighbor]--;
                    if(degree[neighbor] == 1) {
                        queue.add(neighbor);
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()) {
            result.add(queue.poll());
        }

        return result;
    }
}