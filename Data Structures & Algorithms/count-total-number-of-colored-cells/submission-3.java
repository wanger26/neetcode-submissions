class Solution {
    public long coloredCells(int n) {

        // Time: O(n)
        // Space: O(1)

        if(n == 1) {
            return 1;
        }
        
        long prevValue = 1;

        for(int i=2; i < n; i++) {
            long value = prevValue + 2*(i-1) + 1;
            prevValue = value;
        }

        return 2* prevValue + 2*n - 1;

    }
}
