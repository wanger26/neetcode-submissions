class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {

        // Time: O(n+m)
        // Space: O(n+m)
        List<int[]> resultList = new ArrayList<>();

        int nums1Index = 0;
        int nums2Index = 0;

        while(nums1Index < nums1.length && nums2Index < nums2.length) {
            int id1 = nums1[nums1Index][0];
            int id2 = nums2[nums2Index][0];

            if(id1 == id2) {
                resultList.add(new int[]{id1, nums1[nums1Index][1] + nums2[nums2Index][1]});
                nums1Index++;
                nums2Index++;
            } else if (id1 < id2) {
                resultList.add(nums1[nums1Index++]);
            } else {
                resultList.add(nums2[nums2Index++]);
            }
        }

        while(nums1Index < nums1.length) {
            resultList.add(nums1[nums1Index++]);
        }

        while(nums2Index < nums2.length) {
            resultList.add(nums2[nums2Index++]);
        }

        int[][] result = new int[resultList.size()][2];
        for(int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}
