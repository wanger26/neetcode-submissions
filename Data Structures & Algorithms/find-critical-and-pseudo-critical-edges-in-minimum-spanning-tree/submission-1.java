class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<int[]> edgeList = new ArrayList<>();
        for(int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int node1 = edge[0];
            int node2 = edge[1];
            int weight = edge[2];
            edgeList.add(new int[]{node1, node2, weight, i});
        }

        // Sort by weight
        edgeList.sort(Comparator.comparingInt(a -> a[2]));

        // Make MST
        int mstWeight = 0;
        UnionFind uf = new UnionFind(n);
        for(int[] edge : edgeList) {
            // If it can be added, then we add to mst weight
            if(uf.union(edge[0], edge[1])) {
                mstWeight += edge[2];
            }
        }

        // Find Critical and Pseudo nodes
        List<Integer> critical = new ArrayList<>();
        List<Integer> psudeo = new ArrayList<>();
        for(int i=0; i < edgeList.size(); i++) {
            int[] edge = edgeList.get(i);
            // Try making MST without current node
            int weight = 0;
            int edgeCount = 0;
            UnionFind ufWithout = new UnionFind(n);
            for(int j = 0; j < edgeList.size(); j++) {
                if(i == j) {
                    continue;
                }

                int[] other = edgeList.get(j);
                if(ufWithout.union(other[0], other[1])) {
                    weight += other[2];
                    edgeCount++;
                }
            }

            // We make a disconnected graph or the weight increased
            if(edgeCount != n-1 || weight > mstWeight) {
                critical.add(edge[3]);
                continue;
            }

            // Try making MST with current node
            UnionFind ufWith = new UnionFind(n);
            ufWith.union(edge[0], edge[1]);
            weight = edge[2];

            for(int j = 0; j < edgeList.size(); j++) {
                if(i == j) {
                    continue;
                }

                int[] other = edgeList.get(j);
                if(ufWith.union(other[0], other[1])) {
                    weight += other[2];
                }
            }

            if(weight == mstWeight) {
                psudeo.add(edge[3]);
            }

        }

        return Arrays.asList(critical, psudeo);

    }


    class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];

            for(int i=0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int v) {
            if(parent[v] != v) {
                parent[v] = find(parent[v]);
            }

            return parent[v];
        }

        public boolean union(int v1, int v2) {
            int parent1 = find(v1);
            int parent2 = find(v2);

            if(parent1 == parent2) {
                return false;
            }

            if(rank[parent1] > rank[parent2]) {
                parent[parent2] = parent1;
                rank[parent1] += rank[parent2];
            } else {
                parent[parent1] = parent2;
                rank[parent2] += rank[parent1];
            }

            return true;
        }
    }
}