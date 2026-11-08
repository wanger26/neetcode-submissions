class Solution {
    public int numberOfSubstrings(String s) {
        //   | |
        // "abca"
        //  a: 2
        //  b: 1
        //  c: 1

        int result = 0;
        int left = 0;
        int[] count = new int[3];

        // Time: O(n)
        // Space: O(1)
        for(int right = 0; right < s.length(); right++) {
            char character = s.charAt(right);
            count[character - 'a']++;

            while(count[0] > 0 && count[1] > 0 && count[2] > 0) {
                result += 1 + (s.length() - right - 1);
                count[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return result;
    }
}
