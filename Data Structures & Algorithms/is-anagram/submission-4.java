class Solution {
    public boolean isAnagram(String s, String t) {

        // Time: O(n+m)
        // Space: O(1)
        int[] freqCount = new int[26];
        for(int i = 0; i < s.length(); i++) {
            freqCount[s.charAt(i)-'a']++;
        }

        for(int i = 0; i < t.length(); i++) {
            freqCount[t.charAt(i)-'a']--;
        }

        for(int i = 0; i < 26; i++) {
            if(freqCount[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
