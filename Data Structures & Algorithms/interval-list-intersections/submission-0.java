class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> resultList = new ArrayList<>();

        int firstIndex = 0;
        int secondIndex = 0;

        while(firstIndex < firstList.length && secondIndex < secondList.length) {
            int firstStart = firstList[firstIndex][0];
            int firstEnd = firstList[firstIndex][1];

            int secondStart = secondList[secondIndex][0];
            int secondEnd = secondList[secondIndex][1];

            if(firstEnd < secondStart) {
                // No intersection. Move first
                firstIndex++;
            } else if (secondEnd < firstStart) {
                secondIndex++;
            } else {
                resultList.add(new int[]{Math.max(firstStart, secondStart), Math.min(firstEnd, secondEnd)});
                if(firstEnd < secondEnd) {
                    firstIndex++;
                } else {
                    secondIndex++;
                }
            }
        }

        int[][] result = new int[resultList.size()][2];
        for(int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}