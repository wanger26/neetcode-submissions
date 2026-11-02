class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        // Time: O(n)
        // Space: O(1)
        int[] s1FreqCount = new int[26];
        int[] s2FreqCount = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1FreqCount[s1.charAt(i) - 'a']++;
            s2FreqCount[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (s1FreqCount[i] != s2FreqCount[i]) {
                return false;
            }
        }

        int numOfOutOfPosition = 0;
        for (int i = 0; i < s1.length() && numOfOutOfPosition <= 2; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                numOfOutOfPosition++;
            }
        }

        return numOfOutOfPosition <= 2;
    }
}
