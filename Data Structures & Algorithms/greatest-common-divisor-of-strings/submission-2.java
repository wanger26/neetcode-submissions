class Solution {
    public String gcdOfStrings(String str1, String str2) {

        // Time: O(m * (m+n))
        // Space: O(m + n)
        
        int length1 = str1.length();
        int length2 = str2.length();
        
        if (length1 < length2) {
            return gcdOfStrings(str2, str1);
        }

        // Time: O(m)
        for(int i=length2; i >= 1; i--) {
            if(length1 % i != 0 || length2 % i != 0) {
                continue;
            }

            String candidate = str2.substring(0, i);
            StringBuilder bldr1 = new StringBuilder();

            // O(n)
            for(int j = 0; j < length1/i; j++) {
                bldr1.append(candidate);
            }

            // O(m)
            StringBuilder bldr2 = new StringBuilder();
            for(int j = 0; j < length2/i; j++) {
                bldr2.append(candidate);
            }

            if(bldr1.toString().equals(str1) && bldr2.toString().equals(str2)) {
                return candidate;
            }
        }

        return "";
        
    }
}