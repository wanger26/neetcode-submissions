class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {

        // Time: O(n)
        // Space: O(1)
        int n = colors.length;

        int left = 0;
        int right = 1;

        int result = 0;
        while(left < n) {
            if(colors[right%n] == colors[(right-1)% n]) {
                left = right;
            } else if(right - left + 1 == k) {
                result++;
                left++;
            }
            right++;
        }

        return result;
    }
}
