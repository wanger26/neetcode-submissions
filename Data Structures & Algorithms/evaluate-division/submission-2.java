class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        // Time: O(e+q*(v+e)) where e is the nuber of equations, q is the number of queries and v is the number of variables/edges
        // Space: O(e + v)
        Map<String, Map<String, Double>> map = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            double value = values[i];

            String numerator = equation.get(0);
            String denominator = equation.get(1);

            if (!map.containsKey(numerator)) {
                map.put(numerator, new HashMap<>());
            }

            if (!map.containsKey(denominator)) {
                map.put(denominator, new HashMap<>());
            }

            map.get(numerator).put(denominator, value);
            map.get(denominator).put(numerator, 1.0 / value);
        }

        int index = 0;
        double[] result = new double[queries.size()];
        for (List<String> query : queries) {
            String numerator = query.get(0);
            String denominator = query.get(1);

            if (!map.containsKey(numerator) || !map.containsKey(denominator)) {
                result[index++] = -1.0;
            } else if (numerator.equals(denominator)) {
                result[index++] = 1.0;
            } else {
                Set<String> seen = new HashSet<>();
                seen.add(numerator);
                result[index++] = dfs(map, numerator, denominator, seen);
            }
        }

        return result;
    }

    private double dfs(Map<String, Map<String, Double>> map, String currentNode, String target, Set<String> seen) {
        if (!map.containsKey(currentNode)) {
            return -1.0;
        } else if (currentNode.equals(target)) {
            return 1;
        }

        Double answer = null;
        for (Map.Entry<String, Double> edge : map.get(currentNode).entrySet()) {
            String node = edge.getKey();
            double value = edge.getValue();

            if (seen.contains(node)) {
                continue;
            }

            seen.add(node);
            double result = dfs(map, node, target, seen);
            if (result != -1.0) {
                return result * value;
            }
            seen.remove(node);
        }

        return answer == null ? -1.0 : answer;
    }
}