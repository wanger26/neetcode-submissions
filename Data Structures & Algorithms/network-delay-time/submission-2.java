class Solution {

    // Time: O(elogV)
    // Space: O(V+E)
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Node>> nodeIdToNeighbors = new HashMap<>();
        for (int[] time : times) {
            int source = time[0];
            int target = time[1];
            int t = time[2];

            nodeIdToNeighbors.computeIfAbsent(source, s -> new ArrayList<>())
                .add(new Node(target, t));
        }

        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Node> minQueue = new PriorityQueue<>((a, b) -> a.time() - b.time());
        minQueue.add(new Node(k, 0));

        int[] minTime = new int[n + 1];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        minTime[k] = 0;

        int result = 0;
        while (!minQueue.isEmpty()) {
            Node currentNode = minQueue.poll();
            int currentId = currentNode.id();
            int currentTime = currentNode.time();

            if(visited.contains(currentId)) {
                continue;
            }

            visited.add(currentId);
            result = currentTime;

            if (!nodeIdToNeighbors.containsKey(currentId)) {
                continue;
            }

            for (Node neighbor : nodeIdToNeighbors.get(currentId)) {
                int totalTime = currentTime + neighbor.time();
                // If there is a chance this path leads to a smaller value. Try it.
                if (totalTime < minTime[neighbor.id()]) {
                    minTime[neighbor.id()] = totalTime;
                    minQueue.add(new Node(neighbor.id(), totalTime));
                }
            }
        }

        return visited.size() == n ? result : -1;
    }

    private record Node(int id, int time) {}
}
