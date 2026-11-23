class Solution {
    public int minFlips(String s) {

        // Time: O(n)
        // Space: O(n)
        String string = s + s;
        StringBuilder startingWith0Bldr = new StringBuilder();
        StringBuilder startingWith1Bldr = new StringBuilder();
        for(int i = 0; i < string.length(); i++) {
            if(i % 2 == 0) {
                startingWith0Bldr.append('0');
                startingWith1Bldr.append('1');
            } else {
                startingWith0Bldr.append('1');
                startingWith1Bldr.append('0');
            }
        }

        String startingWith0 = startingWith0Bldr.toString();
        String startingWith1 = startingWith1Bldr.toString();

        int result = Integer.MAX_VALUE;
        int startingWith0Mismatches = 0;
        int startingWith1Mismatches = 0;
        for(int i = 0; i < string.length() && result > 0; i++) {
            char character = string.charAt(i);
            if(character != startingWith0.charAt(i)) {
                startingWith0Mismatches++;
            } else {
                startingWith1Mismatches++;
            }

            if(i >= s.length()) {
                int leftIndex = i - s.length();
                if(string.charAt(leftIndex) != startingWith0.charAt(leftIndex)) {
                    startingWith0Mismatches--;
                } else {
                    startingWith1Mismatches--;
                }
            }

            if(i >= s.length() - 1) {
                result = Math.min(result, Math.min(startingWith0Mismatches, startingWith1Mismatches));
            }
        }

        return result;
    }
}
