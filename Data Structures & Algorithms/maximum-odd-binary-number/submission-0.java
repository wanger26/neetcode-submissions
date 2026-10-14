class Solution {
    public String maximumOddBinaryNumber(String s) {
        StringBuilder bldr = new StringBuilder();
        bldr.append(1);

        int numberOf1s = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') {
                numberOf1s++;
            }
        }

        for(int i=0; i < s.length() - numberOf1s; i++) {
            bldr.append(0);
        }

        for(int i = 1; i < numberOf1s; i++) {
            bldr.append(1);
        }

        return bldr.reverse().toString();
        
    }
}