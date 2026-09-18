class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {

        // Time: O(eloge)
        // Space: O(e)
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for(List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            
            if(!graph.containsKey(from)) {
                graph.put(from, new PriorityQueue<>());
            }

            graph.get(from).add(to);
        }

        List<String> result = new LinkedList<>();
        dfs("JFK", graph, result);

        return result;
    }

    private void dfs(String airport, Map<String, PriorityQueue<String>> graph, List<String> result) {
        
        PriorityQueue<String> destinations = graph.get(airport);

        // Keep flying until there are no flights left out of this airport
        while(destinations != null && !destinations.isEmpty()) {
            dfs(destinations.poll(), graph, result);
        }

        result.addFirst(airport);
    }
}
