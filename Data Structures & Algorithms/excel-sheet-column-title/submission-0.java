class Solution {
    public String convertToTitle(int columnNumber) {
       StringBuilder strBldr = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            int offset = columnNumber % 26;
            strBldr.append((char) ('A' + offset));
            columnNumber /= 26;
        }
        return strBldr.reverse().toString();
    }
}