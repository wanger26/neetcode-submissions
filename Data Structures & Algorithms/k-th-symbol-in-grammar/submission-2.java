class Solution {
    public int kthGrammar(int n, int k) {

        int left = 1;
        int right = (int)Math.pow(2, n-1);

        int currentValue = 0;
        while(left < right) {
            int pivot = (left + right) / 2;

            if(k <= pivot) {
                right = pivot;
            } else {
                currentValue = currentValue == 0 ? 1 : 0;
                left = pivot + 1;
            }
        }

        return currentValue;
    }
}
