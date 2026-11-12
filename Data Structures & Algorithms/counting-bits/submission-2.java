class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n+1];

        for (int num = n; num >= 0; num--) {
            int value = num;

            while(value > 0) {
                if((value & 1) == 1) {
                    result[num]++;
                }

                value >>>= 1;
            }
        }

        return result;
    }
}
