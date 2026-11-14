class Solution {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {

        // Time: O(vlogv)
        // Space: O(v+e)
        int n = vals.length;

        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        Map<Integer, List<Integer>> nodesByValue = new TreeMap<>();
        for(int node = 0; node < n; node++) {
            int value = vals[node];
            if(!nodesByValue.containsKey(value)) {
                nodesByValue.put(value, new ArrayList<>());
            }
            nodesByValue.get(value).add(node);
        }

        UnionFind uf = new UnionFind(n);
        int result = 0;

        for(List<Integer> nodes : nodesByValue.values()) {
            for(int node : nodes) {
                for(int neighbor : graph[node]) {
                    if(vals[neighbor] <= vals[node]) {
                        uf.union(node, neighbor);
                    }
                }
            }

            Map<Integer, Integer> countByRoot = new HashMap<>();
            for(int node : nodes) {
                int root = uf.find(node);
                countByRoot.put(root, countByRoot.getOrDefault(root, 0) + 1);
            }

            for(int count : countByRoot.values()) {
                result += count * (count + 1) / 2;
            }
        }

        return result;
    }

    class UnionFind {
        private int[] parent;
        private int[] rank;

        UnionFind(int n) {
            this.rank = new int[n];
            this.parent = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int node) {
            if (parent[node] != node) {
                parent[node] = find(parent[node]);
            }
            return parent[node];
        }

        void union(int node1, int node2) {
            int parent1 = find(node1);
            int parent2 = find(node2);

            if (parent1 == parent2) {
                return;
            } else if (rank[parent1] < rank[parent2]) {
                parent[parent1] = parent2;
            } else if (rank[parent2] < rank[parent1]) {
                parent[parent2] = parent1;
            } else {
                parent[parent2] = parent1;
                rank[parent1]++;
            }
        }
    }
}
