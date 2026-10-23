class Solution {
    public int numTeams(int[] rating) {

        // Time: O(n^2)
        // Space: O(1)

        int n = rating.length;
        int result = 0;

        for (int j = 0; j < n; j++) {
            int leftSmaller = 0;
            int leftGreater = 0;
            int rightSmaller = 0;
            int rightGreater = 0;

            // Count ratings on the left of j
            for (int i = 0; i < j; i++) {
                if (rating[i] < rating[j]) {
                    leftSmaller++;
                } else {
                    leftGreater++;
                }
            }

            // Count ratings on the right of j
            for (int k = j + 1; k < n; k++) {
                if (rating[k] < rating[j]) {
                    rightSmaller++;
                } else {
                    rightGreater++;
                }
            }

            // Increasing teams + decreasing teams
            result += leftSmaller * rightGreater;
            result += leftGreater * rightSmaller;
        }

        return result;
    }
}