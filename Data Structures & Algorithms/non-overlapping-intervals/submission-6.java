class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        // Input: intervals = [[1,2],[1,4],[2,4]]
        //                       |           |  


        // Input: intervals = [[1,100],[2,4],[4,5]]
        //                        |      |

        // Input: intervals = [[2,4],[4,5],[1,100]]

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int result = 0;

        int currentEnd = Integer.MIN_VALUE;
        for(int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            if(start < currentEnd) {
                result++;
                currentEnd = Math.min(currentEnd, end);
            } else {
                currentEnd = end;
            }
        }

        return result;
    }
}
