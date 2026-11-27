class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        UnionFind uf = new UnionFind(n+1);
        int[] result = null;
        for(int[] edge : edges) {
            boolean isNotCycle = uf.union(edge[0], edge[1]);

            if(!isNotCycle) {
                result = edge;
            }
        }

        return result;

    }


    class UnionFind {
        int[] parent;
        int[] rank;

        UnionFind(int n) {
            this.parent = new int[n];
            this.rank = new int[n];

            for(int i = 1; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int node) {
            if(parent[node] != node) {
                parent[node] = find(parent[node]);
            }

            return parent[node];
        }

        boolean union(int node1, int node2) {
            int parent1 = find(node1);
            int parent2 = find(node2);

            if(parent1 == parent2) {
                return false;
            } else if (rank[parent1] < rank[parent2]) {
                parent[parent1] = parent2;
                rank[parent2] += rank[parent1];
            } else {
                parent[parent2] = parent1;
                rank[parent1] += rank[parent1];
            }

            return true;
        }
    }
}
