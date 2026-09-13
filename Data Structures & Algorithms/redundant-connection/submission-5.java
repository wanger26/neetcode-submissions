class Solution {
    public int[] findRedundantConnection(int[][] edges) {

        int[] parent = new int[edges.length+1];
        int[] rank = new int[edges.length+1];

        for(int i = 1; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for(int[] edge : edges) {
            if(!union(parent, rank, edge[0], edge[1])) {
                return new int[]{edge[0], edge[1]};
            }
        }

        return null;
    }


    private boolean union(int[] parent, int[] rank, int node1, int node2) {
        int parent1 = find(parent, node1);
        int parent2 = find(parent, node2);

        if(parent1 == parent2) {
            return false;
        } else if (rank[parent1] > rank[parent2]) {
            parent[parent2] = parent1;
            rank[parent1] += rank[parent2];
        } else {
            parent[parent1] = parent2;
            rank[parent2] += rank[parent1];
        }

        return true;
    }

    private int find(int[] parent, int node) {
        if(parent[node] == node) {
            return node;
        }
        parent[node] = find(parent, parent[node]);

        return parent[node];
    }
}
