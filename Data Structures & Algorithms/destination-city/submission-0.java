class Solution {
    public String destCity(List<List<String>> paths) {

        // Time: O(n)
        // Space: O(n)
        Map<String, String> graph = new HashMap<>();

        for(List<String> path : paths) {
            graph.put(path.get(0), path.get(1));
        }

        String currentCity = paths.get(0).get(1);
        while(graph.containsKey(currentCity)) {
            currentCity = graph.get(currentCity);
        }

        return currentCity;
    }
}
