class Solution {
    public String maximumOddBinaryNumber(String s) {

        // Time: O(n)
        // Time: O(1)
        StringBuilder bldr = new StringBuilder();

        int numberOf1s = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') {
                numberOf1s++;
            }
        }

        for(int i = 1; i < numberOf1s; i++) {
            bldr.append(1);
        }

        for(int i=0; i < s.length() - numberOf1s; i++) {
            bldr.append(0);
        }

        bldr.append(1);

        return bldr.toString();
        
    }
}