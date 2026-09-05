class Solution {

    // Time: O(n)
    // Space: O(1)
    public int numDecodings(String s) {
        int prevNumOfDecodings = 1;
        int prevPrevNumOfDecodings = 0;

        for(int i=s.length()-1; i >= 0; i--) {
            if(s.charAt(i) == '0') {
                prevPrevNumOfDecodings = prevNumOfDecodings;
                prevNumOfDecodings = 0;
                continue;
            }

            int numOfDecodings = prevNumOfDecodings;
            if(i+1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) <= '6'))) {
                numOfDecodings += prevPrevNumOfDecodings; // If we can make a valid letter with the previous char add that prev points as well
            }
            prevPrevNumOfDecodings = prevNumOfDecodings;
            prevNumOfDecodings = numOfDecodings;
        }

        return prevNumOfDecodings;
    }
}
