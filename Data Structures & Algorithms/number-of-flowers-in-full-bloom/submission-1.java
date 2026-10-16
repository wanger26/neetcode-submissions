class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        PriorityQueue<Integer> minQueueStart = new PriorityQueue<>((a,b) -> a-b);
        PriorityQueue<Integer> minQueueEnd = new PriorityQueue<>((a,b) -> a-b);

        PriorityQueue<Integer> minPerson = new PriorityQueue<>((a,b) -> people[a] - people[b]);

        for(int i = 0; i < people.length; i++) {
            minPerson.add(i);
        }

        for(int[] flower : flowers) {
            minQueueStart.add(flower[0]);
            minQueueEnd.add(flower[1]);
        }

        int[] result = new int[people.length];
        int currentBlooming = 0;
        while (!minPerson.isEmpty()) {
            int arrivalIndex = minPerson.poll();
            int arrival = people[arrivalIndex];


            while(!minQueueStart.isEmpty() && arrival >= minQueueStart.peek()) {
                currentBlooming++;
                minQueueStart.poll();
            }

            while(!minQueueEnd.isEmpty() && arrival > minQueueEnd.peek()) {
                currentBlooming--;
                minQueueEnd.poll();
            }

            result[arrivalIndex] = currentBlooming;
        }

        return result;

    }
}
