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
    public int minMeetingRooms(List<Interval> intervals) {

        // Time: O(nlogn)
        // Space: O(logn)
        int result = 0;
        intervals.sort((a,b) -> a.start - b.start);

        PriorityQueue<Integer> minQueueEndTime = new PriorityQueue<>((a,b) -> a - b);

        for(Interval meeting : intervals) {
            while(!minQueueEndTime.isEmpty() && minQueueEndTime.peek() <= meeting.start) {
                minQueueEndTime.poll();
            }
            minQueueEndTime.add(meeting.end);

            result = Math.max(result, minQueueEndTime.size());
        }

        return result;
    }
}
