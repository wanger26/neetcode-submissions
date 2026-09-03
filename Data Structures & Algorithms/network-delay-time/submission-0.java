class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Set<Node>> nodeIdToNeighbors = new HashMap<>();
        for (int[] time : times) {
            int source = time[0];
            int target = time[1];
            int t = time[2];

            nodeIdToNeighbors.computeIfAbsent(source, s -> new HashSet<>())
                .add(new Node(target, t));
        }

        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Node> minQueue = new PriorityQueue<>((a, b) -> a.time() - b.time());
        minQueue.add(new Node(k, 0));

        int[] minTime = new int[n + 1];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        minTime[k] = 0;

        while (!minQueue.isEmpty()) {
            Node currentNode = minQueue.poll();
            if(!visited.add(currentNode.id())) {
                continue;
            }

            if (!nodeIdToNeighbors.containsKey(currentNode.id())) {
                continue;
            }

            for (Node neighbor : nodeIdToNeighbors.get(currentNode.id())) {
                int totalTime = currentNode.time() + neighbor.time();
                // If there is a chance this path leads to a smaller value. Try it
                if (totalTime < minTime[neighbor.id()]) {
                    minTime[neighbor.id()] = totalTime;
                    minQueue.add(new Node(neighbor.id(), totalTime));
                }
            }
        }

        if (visited.size() != n) {
            return -1;
        }

        int result = 0;
        for (int i = 1; i < minTime.length; i++) {
            result = Math.max(result, minTime[i]);
        }
        return result;
    }

    private record Node(int id, int time) {}
}
