/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {

    // Time: O(nlogn)
    // Space: O(1)
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort((a, b) -> a.start - b.start);

        for(int i=1; i < intervals.size(); i++) {
            Interval prevInterval = intervals.get(i-1);
            Interval currentInterval = intervals.get(i);

            if(currentInterval.start < prevInterval.end) {
                return false;
            }
        }

        return true;
    }
}

