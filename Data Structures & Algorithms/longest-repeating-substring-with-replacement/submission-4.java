class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];

        int left = 0;
        int right = 0;
        int max = 0;

        while (right < s.length()) {
            int rightIndex = s.charAt(right) - 'A';
            count[rightIndex]++;

            int maxFrequency = 0;
            for (int i = 0; i < count.length; i++) {
                maxFrequency = Math.max(maxFrequency, count[i]);
            }
            int nonMatchingChars = right - left + 1 - maxFrequency;
            if (nonMatchingChars > k) {
                int leftIndex = s.charAt(left) - 'A';
                count[leftIndex]--;
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }

        return max;
    }
}
