class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums1Nums = new HashSet<>();
        for(int num : nums1) {
            nums1Nums.add(num);
        }

        Set<Integer> result = new HashSet<>();
        for(int num : nums2) {
            if(nums1Nums.contains(num)) {
                result.add(num);
            }
        }

        int[] resultArray = new int[result.size()];
        int index = 0;
        for(int num : result) {
            resultArray[index++] = num;
        }

        return resultArray;
    }
}