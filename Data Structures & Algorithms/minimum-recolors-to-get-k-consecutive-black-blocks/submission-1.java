class Solution {
    public int minimumRecolors(String blocks, int k) {
        int left = 0;
        int right = k-1;

        int numberOfWhiteBlocks = 0;
        for(int i = 0; i < k; i++) {
            if(blocks.charAt(i) == 'W') {
                numberOfWhiteBlocks++;
            }
        }

        int result = numberOfWhiteBlocks;
        while(right < blocks.length()) {
            result = Math.min(result, numberOfWhiteBlocks);

            // Move forward
            if(blocks.charAt(left) == 'W') {
                numberOfWhiteBlocks--;
            }
            left++;
            right++;
            if(right < blocks.length() && blocks.charAt(right) == 'W') {
                numberOfWhiteBlocks++;
            }
        }

        return result;
    }
}