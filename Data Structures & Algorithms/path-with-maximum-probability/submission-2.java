class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

        // Time: O((e+v)logV)
        // Space: O(e+v)
        
        List<double[]>[] graph = new List[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < edges.length; i++) {
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            double probability = succProb[i];

            graph[node1].add(new double[] {(double) node2, probability});
            graph[node2].add(new double[] {(double)node1, probability});
        }

        double[] probabilities = new double[n];
        probabilities[start_node] = 1;

        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((a,b) -> Double.compare(probabilities[b], probabilities[a]));
        maxQueue.add(start_node);

        boolean[] visited = new boolean[n];

        while(!maxQueue.isEmpty()) {
            int currentNodeId = maxQueue.poll();

            if(visited[currentNodeId]) {
                continue;
            }

            double currentNodeProbability = probabilities[currentNodeId];
            visited[currentNodeId] = true;
            

            for(double[] neighbor : graph[currentNodeId]) {
                int neighborId = (int) neighbor[0];
                double probability = neighbor[1];

                if(visited[(int) neighborId]) {
                    continue;
                }

                if(probabilities[neighborId] < currentNodeProbability * probability) {
                    probabilities[neighborId] = currentNodeProbability * probability;
                    maxQueue.add(neighborId);
                }
            }
        }

        return probabilities[end_node];

    }
}