class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        } else if(x < 3) {
            return 1;
        }
        
        int left = 1;
        int right = x/2;
        while(left <= right) {
            int pivot = (left+right)/2;
            long squared = (long)pivot * pivot;

            if(x == squared) {
                return pivot;
            } else if (x < squared) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }

        return right;
    }
}