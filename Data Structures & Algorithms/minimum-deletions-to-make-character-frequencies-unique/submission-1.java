class Solution {
    public int minDeletions(String s) {

        // Time: O(n)
        // Space: O(1)
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        Arrays.sort(freq);

        int result = 0;
        for (int i = 24; i >= 0 && freq[i] > 0; i--) {
            int nextSlot = Math.max(0, freq[i + 1] - 1);

            if (freq[i] > nextSlot) {
                result += freq[i] - nextSlot;
                freq[i] = nextSlot;
            }
        }

        return result;
    }
}