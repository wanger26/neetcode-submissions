class MedianFinder {

    private PriorityQueue<Integer> biggestSmallNumbers;
    private PriorityQueue<Integer> smallestBigNumbers;

    public MedianFinder() {
        biggestSmallNumbers = new PriorityQueue<>((a, b) -> b-a);
        smallestBigNumbers = new PriorityQueue<>((a, b) -> a-b);
    }
    
    // Time: O(logn)
    public void addNum(int num) {
        biggestSmallNumbers.add(num);

        if(biggestSmallNumbers.size() - smallestBigNumbers.size() > 1 || (!smallestBigNumbers.isEmpty() && biggestSmallNumbers.peek() > smallestBigNumbers.peek())) {
            smallestBigNumbers.add(biggestSmallNumbers.poll());
        }

        if(smallestBigNumbers.size() - biggestSmallNumbers.size() > 1) {
            biggestSmallNumbers.add(smallestBigNumbers.poll());
        }
    }
    
    // Time: O(1)
    public double findMedian() {
        if(biggestSmallNumbers.size() == smallestBigNumbers.size()) {
            return ((double)(biggestSmallNumbers.peek() + smallestBigNumbers.peek()))/2.0;
        }

        return biggestSmallNumbers.size() < smallestBigNumbers.size() ? smallestBigNumbers.peek() : biggestSmallNumbers.peek();
    }
}
