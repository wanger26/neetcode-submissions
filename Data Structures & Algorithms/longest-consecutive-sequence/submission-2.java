class Solution {
    public int longestConsecutive(int[] nums) {
        int longestSequence = 0;
        Map<Integer, Integer> numberToSequenceMap = new HashMap<>();
        for (int num : nums) {
            if (!numberToSequenceMap.containsKey(num)) {
                int leftLongestSequence = numberToSequenceMap.getOrDefault(num-1, 0);
                int rightLongestSequence = numberToSequenceMap.getOrDefault(num+1, 0);

                int currentSequence = leftLongestSequence + rightLongestSequence + 1;

                numberToSequenceMap.put(num, currentSequence);

                
                numberToSequenceMap.computeIfPresent(num - leftLongestSequence, (key, value) -> currentSequence);
                numberToSequenceMap.computeIfPresent(num + rightLongestSequence, (key, value) -> currentSequence);

                if (currentSequence > longestSequence) {
                    longestSequence = currentSequence;
                }
            }
        }

        return longestSequence;
        // Set<Integer> numbers = new HashSet<>();
        // for(int num : nums) {
        //     numbers.add(num);
        // }

        // int longestSequence = 0;
        // for(int num : nums) {
        //     if(!numbers.contains(num-1)) {
        //         int currentLength = 1;
        //         while(numbers.contains(++num)) {
        //             currentLength++;
        //         }

        //         if (currentLength > longestSequence) {
        //             longestSequence = currentLength;
        //         }
        //     }
        // }

        // return longestSequence;
    }
}
