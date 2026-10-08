class Solution {
    public boolean isSubsequence(String s, String t) {

        // Time: O(Min(s,t))
        // Space: O(1)
        if(s.length() > t.length()) {
            return false;
        }

        int sIndex = 0;
        for(int tIndex = 0 ; tIndex < t.length() && sIndex < s.length(); tIndex++) {
            if(s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
            }
        }

        return sIndex == s.length();
    }
}