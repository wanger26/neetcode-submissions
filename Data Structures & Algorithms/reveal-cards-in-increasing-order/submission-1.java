class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int[] result = new int[deck.length];
        Arrays.sort(deck);

        int index = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < deck.length; i++) {
            queue.add(i);
        }

        for (int card : deck) {
            result[queue.poll()] = card;
            queue.add(queue.poll());
        }

        return result;
    }
}
