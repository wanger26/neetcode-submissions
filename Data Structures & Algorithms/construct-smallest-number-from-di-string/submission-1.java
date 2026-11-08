class Solution {
    public String smallestNumber(String pattern) {

        // Time: O(n)
        // Space: O(1)
        int nextNumber = 1;
        int dValues = 0;

        StringBuilder bldr = new StringBuilder();
        for (int i = 0; i < pattern.length(); i++) {
            char character = pattern.charAt(i);
            if (character == 'I') {
                int firstDValue = nextNumber + dValues;
                for (int j = 0; j < dValues; j++) {
                    bldr.append(firstDValue - j);
                }
                bldr.append(nextNumber);
                nextNumber = firstDValue + 1;
                dValues = 0;
            } else {
                dValues++;
            }
        }

        int firstDValue = nextNumber + dValues;
        for (int j = 0; j < dValues; j++) {
            bldr.append(firstDValue - j);
        }
        bldr.append(nextNumber);

        return bldr.toString();
    }
}
