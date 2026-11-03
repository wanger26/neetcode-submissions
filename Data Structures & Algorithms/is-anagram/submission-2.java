class Solution {
    public boolean isAnagram(String s, String t) {

        // Time: O(n)
        // Space: O(1)
        int n = s.length();
        int m = t.length();

        if(n != m) {
            return false;
        }

        int[] sFreq = new int[26];
        int[] tFreq = new int[26];

        for(int i = 0; i < n; i++) {
            sFreq[s.charAt(i)-'a']++;
            tFreq[t.charAt(i)-'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if(sFreq[i] != tFreq[i]) {
                return false;
            }
        }

        return true;
    }
}
