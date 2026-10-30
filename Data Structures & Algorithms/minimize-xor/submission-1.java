class Solution {
    public int minimizeXor(int num1, int num2) {

        // Time: O(1)
        // Space: O(1)
        int needToSet = 0;
        for (int v = num2; v > 0; v >>= 1) {
            needToSet += v & 1;
        }

        int answer = 0;
        for (int bit = 29; bit >= 0 && needToSet > 0; bit--) {
            if ((num1 & (1 << bit)) != 0) {
                answer |= 1 << bit;
                needToSet--;
            }
        }

        for (int bit = 0; bit <= 29 && needToSet > 0; bit++) {
            if ((num1 & (1 << bit)) == 0) {
                answer |= 1 << bit;
                needToSet--;
            }
        }

        return answer;
    }
}
