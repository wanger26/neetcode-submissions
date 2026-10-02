class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // 0 1 2 3 4
        // 1 2 1 2 1

        // 0 1 2 3
        // 3 1 1 1

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

        int minHeight = n;
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int height = height(graph, i, i, 1, minHeight);
            if(height == minHeight) {
                result.add(i);
            } else if (height < minHeight) {
                minHeight = height;
                result.clear();
                result.add(i);
            }
        }

        return result;
    }

    private int height(Map<Integer, List<Integer>> graph, int currentNode, int parent, int currentHeight, int minHeight) {

        if(currentHeight > minHeight) {
            return currentHeight;
        }

        int result = currentHeight;
        for(int child : graph.get(currentNode)) {
            if(child == parent) {
                continue;
            }
            result = Math.max(result, height(graph, child, currentNode, currentHeight + 1, minHeight));
        }

        
        return result;
    }
}