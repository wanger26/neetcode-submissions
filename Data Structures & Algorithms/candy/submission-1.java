class Solution {
    public int candy(int[] ratings) {

        // Time: O(nlogn)
        // Space: O(n)
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        PriorityQueue<Integer> minValueQueueByIndex = new PriorityQueue<>((a,b) -> ratings[a] - ratings[b]);
        for(int i=0; i < n; i++) {
            minValueQueueByIndex.add(i);
        }

        while(!minValueQueueByIndex.isEmpty()) {
            int minIndex = minValueQueueByIndex.poll();

            if(minIndex - 1 >= 0 && ratings[minIndex-1] > ratings[minIndex]) {
                candies[minIndex - 1] = Math.max(candies[minIndex - 1], candies[minIndex] + 1);
            }

            if(minIndex + 1 < n && ratings[minIndex+1] > ratings[minIndex]) {
                candies[minIndex + 1] = Math.max(candies[minIndex + 1], candies[minIndex] + 1);
            }
        }


        int totalCandies = 0;
        for(int numOfCandy : candies) {
            totalCandies += numOfCandy;
        }

        return totalCandies;

    }
}