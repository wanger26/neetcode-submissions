class Solution {
    // Time: O(n)
    // Space: O(n)
    
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> numToFrequency = new HashMap<>();
        for (int num : hand) {
            numToFrequency.put(num, numToFrequency.getOrDefault(num, 0) + 1);
        }

        for (int num : hand) {
            int start = num;
            while(numToFrequency.getOrDefault(start - 1, 0) > 0) {
                start--;
            }
            while(start <= num) {
                while(numToFrequency.getOrDefault(start, 0) > 0) {
                    for(int i = start; i < start + groupSize; i++) {
                        if(numToFrequency.getOrDefault(i, 0) == 0) {
                            return false;
                        }
                        numToFrequency.put(i, numToFrequency.get(i) - 1);
                    }
                }
                start++;
            }
        }

        return true;
    }
}
