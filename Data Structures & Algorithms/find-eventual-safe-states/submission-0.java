class Solution {
    public int[] eventualSafeNodes(int[][] graph) {

        // Time: O(v + e)
        // Space: O(v + e)
        int n = graph.length;
        List<Integer>[] reversed = new List[n];
        int[] indegree = new int[n];

        for(int i = 0; i < n; i++) {
            reversed[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++) {
            int[] neighbors = graph[i];
            for(int neighbor : neighbors) {
                reversed[neighbor].add(i);
                indegree[i]++;
            }
        }

        int numOfTerminalNodes = 0;
        boolean[] terminalNodes = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int terminalNode = queue.poll();
            terminalNodes[terminalNode] = true;
            numOfTerminalNodes++;

            for(int neighbor : reversed[terminalNode]) {
                indegree[neighbor]--;
                if(indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        int index = 0;
        int[] result = new int[numOfTerminalNodes];
        for(int i = 0; i < n; i++) {
            if(terminalNodes[i]) {
                result[index++] = i;
            }
        }

        return result;
    }
}
