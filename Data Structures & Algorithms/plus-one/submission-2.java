class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        boolean allNine = true;
        for(int i = 0; i < n && allNine; i++) {
            if(digits[i] != 9) {
                allNine = false;
            }
        }

        if(allNine) {
            int[] result = new int[n+1];
            result[0] = 1;
            return result;
        }

        int carryOver = 1;
        int[] result = new int[n];
        for(int i = n-1; i >=0; i--) {
            int sum = digits[i] + carryOver;
            result[i] = sum % 10;
            carryOver = sum / 10;
        }

        return result;
    }
}
