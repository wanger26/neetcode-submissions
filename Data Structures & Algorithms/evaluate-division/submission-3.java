class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        // Time: O(e+q)
        // Space: O(e+q)
        UnionFind uf = new UnionFind();

        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            double value = values[i];

            String numerator = equation.get(0);
            String denominator = equation.get(1);
            uf.union(numerator, denominator, value);
        }

        int index = 0;
        double[] result = new double[queries.size()];
        for (List<String> query : queries) {
            String numerator = query.get(0);
            String denominator = query.get(1);
            result[index++] = uf.getRatio(numerator, denominator);
        }

        return result;
    }

    class UnionFind {
        private final Map<String, String> parent = new HashMap<>();
        private final Map<String, Double> weight = new HashMap<>();
        private final Map<String, Integer> rank = new HashMap<>();

        public void add(String node) {
            if (!parent.containsKey(node)) {
                parent.put(node, node);
                weight.put(node, 1.0);
                rank.put(node, 0);
            }
        }

        public String find(String node) {
            if (!parent.get(node).equals(node)) {
                String originalParent = parent.get(node);
                parent.put(node, find(originalParent));
                weight.put(node, weight.get(node) * weight.get(originalParent));
            }
            return parent.get(node);
        }

        public void union(String node1, String node2, double value) {
            add(node1);
            add(node2);

            String parent1 = find(node1);
            String parent2 = find(node2);

            if (parent1.equals(parent2)) {
                return;
            }

            int rank1 = rank.get(parent1);
            int rank2 = rank.get(parent2);
            if(rank1 < rank2) {
                parent.put(parent1, parent2);
                weight.put(parent1, value * weight.get(node2) / weight.get(node1));
            } else {
                parent.put(parent2, parent1);
                weight.put(parent2, weight.get(node1) / (value * weight.get(node2)));

                if(rank1 == rank2) {
                    rank.put(parent1, rank1+1);
                }
            }
        }

        public double getRatio(String node1, String node2) {
            if (!parent.containsKey(node1) || !parent.containsKey(node2) || !find(node1).equals(find(node2))) {
                return -1;
            }

            return weight.get(node1) / weight.get(node2);
        }
    }
}