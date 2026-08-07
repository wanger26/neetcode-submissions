class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        for(int num : nums) {
            numbers.add(num);
        }

        int longestSequence = 0;
        for(int num : nums) {
            if(!numbers.contains(num-1)) {
                int currentLength = 1;
                while(numbers.contains(++num)) {
                    currentLength++;
                }

                if (currentLength > longestSequence) {
                    longestSequence = currentLength;
                }
            }
        }

        return longestSequence;
    }
}
