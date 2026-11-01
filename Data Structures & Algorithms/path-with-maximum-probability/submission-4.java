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

        PriorityQueue<double[]> maxQueue = new PriorityQueue<>((a,b) -> Double.compare(b[1], a[1]));
        maxQueue.add(new double[] {start_node, 1});

        boolean[] visited = new boolean[n];

        while(!maxQueue.isEmpty()) {
            double[] currentNode = maxQueue.poll();
            int currentNodeId = (int) currentNode[0];
            double currentNodeProbability = currentNode[1];

            if(visited[currentNodeId]) {
                continue;
            } else if (currentNodeId == end_node) {
                return currentNodeProbability;
            }

            visited[currentNodeId] = true;
            

            for(double[] neighbor : graph[currentNodeId]) {
                int neighborId = (int) neighbor[0];
                double probability = neighbor[1];

                if(visited[(int) neighborId]) {
                    continue;
                }

                if(probabilities[neighborId] < currentNodeProbability * probability) {
                    probabilities[neighborId] = currentNodeProbability * probability;
                    maxQueue.add(new double[]{(double)neighborId, probabilities[neighborId]});
                }
            }
        }

        return probabilities[end_node];

    }
}