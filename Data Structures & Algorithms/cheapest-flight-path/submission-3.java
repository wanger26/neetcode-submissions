class Solution {
    // LeetCode Optimized
    // Time: O(e*k) where is e is the number of edges/flights and k is the number of stops
    // Space: O(n)
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] airportToMinPrice = new int[n];
        Arrays.fill(airportToMinPrice, Integer.MAX_VALUE);
        airportToMinPrice[src] = 0;

        int stops = 0;
        while(stops <= k) { // O(k)
            int[] updatedAirportToMinPrice = Arrays.copyOf(airportToMinPrice, n);
            stops++;
            for(int[] flight : flights) { // O(e)
                int source = flight[0];
                int destination = flight[1];
                int price = flight[2];

                // Skip if we cannot calc current total price
                if(airportToMinPrice[source] == Integer.MAX_VALUE) {
                    continue;
                }

                int currentTotalPrice = airportToMinPrice[source] + price;
                int currentMinPrice = updatedAirportToMinPrice[destination];
                updatedAirportToMinPrice[destination] = Math.min(currentTotalPrice, currentMinPrice);
            }
            airportToMinPrice = updatedAirportToMinPrice;
        }

        if(airportToMinPrice[dst] != Integer.MAX_VALUE) {
            return airportToMinPrice[dst];
        }
        
        return -1;
    }
}
