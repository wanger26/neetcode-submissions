class Solution {
    public int largestPathValue(String colors, int[][] edges) {

        // Time: O(v+e)
        // Space: O(v+e)
        int v = colors.length();

        List<Integer>[] map = new List[v];
        for (int i = 0; i < v; i++) {
            map[i] = new ArrayList<>();
        }

        int[] indegree = new int[v];
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            if (from == to) {
                return -1;
            }

            map[from].add(to);
            indegree[to]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        if (queue.isEmpty()) {
            return -1;
        }

        int[][] dp = new int[v][26];
        int processed = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            processed++;

            int currentColor = colors.charAt(node) - 'a';

            dp[node][currentColor]++;
            for (int neighbor : map[node]) {

                for(int color = 0; color < 26; color++) {
                    dp[neighbor][color] = Math.max(dp[neighbor][color], dp[node][color]);
                }

                indegree[neighbor]--;
                if(indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        if(processed != v) {
            return -1;
        }

        int result = 0;
        for(int node = 0; node < v; node++) {
            for(int color = 0; color < 26; color++) {
                result = Math.max(result, dp[node][color]);
            }
        }

        return result;
    }
}
