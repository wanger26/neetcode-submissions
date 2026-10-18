class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {

        List<Integer>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int[] shortestPath = new int[n + 1];
        int[] secondShortestPath = new int[n + 1];
        Arrays.fill(shortestPath, -1);
        Arrays.fill(secondShortestPath, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        shortestPath[1] = 0;

        int pathLength = 0;

        while (!queue.isEmpty() && secondShortestPath[n] == -1) {
            int initialSize = queue.size();

            for (int i = 0; i < initialSize; i++) {
                int node = queue.poll();

                for (int neighbor : graph[node]) {
                    int nextPathLength = pathLength + 1;

                    if (shortestPath[neighbor] == -1) {
                        shortestPath[neighbor] = nextPathLength;
                        queue.add(neighbor);
                    } else if (secondShortestPath[neighbor] == -1 && nextPathLength > shortestPath[neighbor]) {
                        secondShortestPath[neighbor] = nextPathLength;
                        queue.add(neighbor);
                    }
                }
            }

            pathLength++;
        }

        int elapsedTime = 0;

        for (int i = 0; i < secondShortestPath[n]; i++) {
            if ((elapsedTime / change) % 2 == 1) {
                elapsedTime += change - elapsedTime % change;
            }

            elapsedTime += time;
        }

        return elapsedTime;
    }
}