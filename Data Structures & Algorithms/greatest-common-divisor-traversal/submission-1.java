class Solution {
    public boolean canTraverseAllPairs(int[] nums) {

        // Time: O()
        // Space: O()
        int n = nums.length;
        UnionFind unionFind = new UnionFind(n);
        Map<Integer, Integer> primeFactorToIndex = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int number = nums[i];
            int factor = 2;
            while (factor * factor <= number) {
                if (number % factor == 0) {
                    if (primeFactorToIndex.containsKey(factor)) {
                        unionFind.union(i, primeFactorToIndex.get(factor));
                    } else {
                        primeFactorToIndex.put(factor, i);
                    }

                    // Skip all numbers which are not prime factors. E.g. 4, 6, 8 etc.
                    while (number % factor == 0) {
                        number = number / factor;
                    }
                }
                factor++;
            }

            // Covers the last number since we might miss the ceiling of the sqrt of then number
            if (number > 1) {
                if (primeFactorToIndex.containsKey(number)) {
                    unionFind.union(i, primeFactorToIndex.get(number));
                } else {
                    primeFactorToIndex.put(number, i);
                }
            }
        }

        return unionFind.getSize() == 1;
    }

    public class UnionFind {
        private int n;
        private int[] rank;
        private int[] parent;

        public UnionFind(int n) {
            this.n = n;
            this.rank = new int[n];
            this.parent = new int[n];

            for (int i = 0; i < n; i++) {
                this.parent[i] = i;
                this.rank[i] = 1;
            }
        }

        public int find(int node) {
            if (parent[node] != node) {
                parent[node] = find(parent[node]);
            }

            return parent[node];
        }

        public boolean union(int node1, int node2) {
            int parent1 = find(node1);
            int parent2 = find(node2);

            if (parent1 == parent2) {
                return false;
            }
            this.n--;

            if (rank[parent1] < rank[parent2]) {
                parent[parent2] = parent[parent1];
                rank[parent1] += rank[parent2];
            } else {
                parent[parent1] = parent[parent2];
                rank[parent2] += rank[parent1];
            }

            return true;
        }

        public int getSize() {
            return this.n;
        }
    }
}