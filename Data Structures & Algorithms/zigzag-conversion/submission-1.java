class Solution {
    public String convert(String s, int numRows) {

        // Time: O(s)
        // Space: O(s)

        if(numRows == 1) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for(int i=0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        boolean downDirection = true;
        int index = 0;
        for(char character : s.toCharArray()) {
            if (index == -1) {
                index = 1;
                downDirection = true;
            } else if (index == numRows) {
                index = numRows - 2;
                downDirection = false;
            }

            rows.get(index).append(character);

            if (downDirection) {
                index++;
            } else {
                index--;
            }
        }

        StringBuilder result = new StringBuilder();
        for(StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}