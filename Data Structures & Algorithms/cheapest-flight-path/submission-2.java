class Solution {
    // Time: O(e*k) where is e is the number of edges/flights and k is the number of stops
    // Space: O(n)
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Integer> airportToMinPrice = new HashMap<>();
        airportToMinPrice.put(src, 0);

        int stops = 0;
        while(stops <= k) { // O(k)
            Map<Integer, Integer> updatedAirportToMinPrice = new HashMap<>(airportToMinPrice);
            stops++;
            for(int[] flight : flights) { // O(e)
                int source = flight[0];
                int destination = flight[1];
                int price = flight[2];

                // Skip if we cannot calc current total price
                if(!airportToMinPrice.containsKey(source)) {
                    continue;
                }

                int currentTotalPrice = airportToMinPrice.get(source) + price;
                int currentMinPrice = updatedAirportToMinPrice.getOrDefault(destination, Integer.MAX_VALUE);
                updatedAirportToMinPrice.put(destination, Math.min(currentTotalPrice, currentMinPrice));
            }
            airportToMinPrice = updatedAirportToMinPrice;
        }

        if(airportToMinPrice.containsKey(dst) && airportToMinPrice.get(dst) != Integer.MAX_VALUE) {
            return airportToMinPrice.get(dst);
        }
        
        return -1;
    }
}
