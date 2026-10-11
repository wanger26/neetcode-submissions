class Solution {
    public int minimumRecolors(String blocks, int k) {
        int whiteCount = 0;
        
        // Count white blocks in the first window of size k
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                whiteCount++;
            }
        }
        
        int minRecolors = whiteCount;
        
        // Slide the window across the rest of the string
        for (int i = k; i < blocks.length(); i++) {
            // Add the new character entering the window on the right
            if (blocks.charAt(i) == 'W') {
                whiteCount++;
            }
            // Remove the old character leaving the window on the left
            if (blocks.charAt(i - k) == 'W') {
                whiteCount--;
            }
            minRecolors = Math.min(minRecolors, whiteCount);
        }
        
        return minRecolors;
    }
}