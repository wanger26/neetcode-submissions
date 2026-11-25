class Solution {
    public String shiftingLetters(String s, int[][] shifts) {

        // Time: O(n+m)
        // Space: O(n)
        
        int n = s.length();
        int[] difference = new int[n+1];

        for(int[] shift : shifts) {
            int delta = shift[2] == 1 ? 1 : -1;
            difference[shift[0]] += delta;
            difference[shift[1] + 1] -= delta;
        }

        int offset = 0;
        StringBuilder bldr = new StringBuilder();
        for(int i = 0; i < n; i++) {
            char character = s.charAt(i);
            int charIndex = character - 'a';

            offset = (offset + difference[i]) % 26;

            char newCharacter = (char)(((charIndex + 26 + offset) % 26) + 'a');
            bldr.append(newCharacter);
        }

        return bldr.toString();
    }
}
