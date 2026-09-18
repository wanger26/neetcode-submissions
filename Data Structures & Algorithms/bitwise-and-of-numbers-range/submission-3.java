class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        
        int prevResult = right;
        int result = right;
        while(right >= left && prevResult >= result) {
            prevResult = result;
            result &= right;
            right--;
        }

        return result;
    }
}