class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        // Time: O(m+n)
        // Space: O(1)
        int[] freqCount = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            freqCount[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            int charIndex = ransomNote.charAt(i) - 'a';
            freqCount[charIndex]--;

            if(freqCount[charIndex] < 0) {
                return false;
            }
        }

        return true;
    }
}