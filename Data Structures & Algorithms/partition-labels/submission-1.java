class Solution {

    // Time: O(n)
    // Space: O(1)
    public List<Integer> partitionLabels(String s) {
        // xyxxyzbzbbisl
        // x: 3
        // y: 4
        // z: 

        int[] letterLastIndex = new int[26];
        for(int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            letterLastIndex[character - 'a'] = i;
        }

        List<Integer> result = new ArrayList<>();
        int startingIndex = 0;
        int lastLetterIndex = -1;
        for(int i=0; i < s.length(); i++) {
            char character = s.charAt(i);

            // Smallest substring we can make ends where the last letter in the current sequence is
            lastLetterIndex = Math.max(lastLetterIndex, letterLastIndex[character - 'a']);

            // If our index is the last letter in the current sequeuence, we have found min
            if(lastLetterIndex == i) {
                result.add(lastLetterIndex - startingIndex + 1);
                startingIndex = i + 1;
            }
        }

        return result;
    }
}
