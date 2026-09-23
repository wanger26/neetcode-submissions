class Solution {
    public String addBinary(String a, String b) {

        // Time: O(n)
        // Space: O(1)
        int n = a.length();
        int m = b.length();
        if(m < n) {
            return addBinary(b, a);
        }

        boolean remainder = false;
        StringBuilder bldr = new StringBuilder();
        int aIndex = n-1;
        int bIndex = m-1;
        while(aIndex >= 0 || bIndex >= 0) {
            char charA = aIndex < 0 ? '0' : a.charAt(aIndex);
            char charB = b.charAt(bIndex);
            if(charA == '1' && charB == '1') {
                bldr.append(remainder ? '1' : '0');
                remainder = true;
            } else if(charA == '1' || charB == '1') {
                bldr.append(remainder ? '0' : '1');
            } else {
                bldr.append(remainder ? '1' : '0');
                remainder = false;
            }

            aIndex--;
            bIndex--;
        }

        if(remainder) {
            bldr.append('1');
        }

        return bldr.reverse().toString();
    }
}