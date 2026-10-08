class Solution {
    public String largestNumber(int[] nums) {

        // Time: O(nlogn)
        // Space: O(n)
        String[] numsAsNums = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            numsAsNums[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numsAsNums, (a,b) -> (b+a).compareTo(a+b));
        String result = String.join("", numsAsNums);
        return result.charAt(0) == '0' ? "0" : result;
    }
}