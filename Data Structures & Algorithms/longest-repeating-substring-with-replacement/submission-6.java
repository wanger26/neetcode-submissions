class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];

        int left = 0;
        int right = 0;
        int max = 0;
        int maxFrequency = 0;
        while (right < s.length()) {
            int rightIndex = s.charAt(right) - 'A';
            count[rightIndex]++;

            maxFrequency = Math.max(maxFrequency, count[rightIndex]);

            int nonMatchingChars = right - left + 1 - maxFrequency;
            while (nonMatchingChars > k) {
                int leftIndex = s.charAt(left) - 'A';
                count[leftIndex]--;
                left++;
                nonMatchingChars = right - left + 1 - maxFrequency;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }

        return max;
    }
}
