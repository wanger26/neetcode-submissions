class Solution {
    public String addSpaces(String s, int[] spaces) {

        // Time: O(n+m + nlogn)
        // Space: O(logn)
        Arrays.sort(spaces);

        StringBuilder bldr = new StringBuilder();
        int spacesIndex = 0;
        for(int i = 0; i < s.length(); i++) {
            while(spacesIndex < spaces.length && i == spaces[spacesIndex]) {
                bldr.append(' ');
                spacesIndex++;
            }
            bldr.append(s.charAt(i));
        }

        return bldr.toString();
    }
}
