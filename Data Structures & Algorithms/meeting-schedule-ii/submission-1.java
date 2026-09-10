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
    // Space: O(n)
    public int minMeetingRooms(List<Interval> intervals) {

        if(intervals.isEmpty()) {
            return 0;
        }

        intervals.sort((a,b) -> a.start - b.start);

        PriorityQueue<Integer> nextMeetingRoomAvailTime = new PriorityQueue<>((a,b) -> a-b);
        int result = 0;
        for(Interval meeting : intervals) {
            nextMeetingRoomAvailTime.add(meeting.end);
            if(nextMeetingRoomAvailTime.isEmpty() || meeting.start >= nextMeetingRoomAvailTime.peek()) {
                nextMeetingRoomAvailTime.poll();
            }
            result = Math.max(result, nextMeetingRoomAvailTime.size());
        }

        return result;
    }
}
