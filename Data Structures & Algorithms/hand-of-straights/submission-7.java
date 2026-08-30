class Solution {

    // Time: O(nlogn)
    // Space: O(n)
    public boolean isNStraightHand(int[] hand, int groupSize) {

        if(hand.length % groupSize != 0) {
            return false;
        }

        SortedMap<Integer, Integer> numToFrequency = new TreeMap<>();
        for(int num : hand) {
            numToFrequency.put(num, numToFrequency.getOrDefault(num, 0) + 1);
        }

        int groupSizeLeft = groupSize;
        for(int num = numToFrequency.firstKey(); !numToFrequency.isEmpty(); num++) {
            if(!numToFrequency.containsKey(num)) {
                return false;
            }
            groupSizeLeft--;

            numToFrequency.put(num, numToFrequency.get(num) - 1);
            if(numToFrequency.get(num) == 0) {
                numToFrequency.remove(num);
            }

            if(groupSizeLeft == 0) {
                groupSizeLeft = groupSize;
                if(!numToFrequency.isEmpty()) {
                    num = numToFrequency.firstKey() - 1; // Counter increases it on top
                }
            }
        }
        
        return true;
    }
}
