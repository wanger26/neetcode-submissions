class Solution {
    public int countDays(int days, int[][] meetings) {
        // meetings = [[2,3],[3,5]]
        
        // lastMeetingDay = 0
        // result (currentStart - lastMeetingDay - 1): 1

        // At end days - last meetingDay: do not sub 1 here
        // 4


        // Sorting meetings by start
        Arrays.sort(meetings, (a,b) -> a[0] - b[0]);

        int result = 0;
        int lastMeetingDay = 0;
        for (int[] meeting : meetings) {
            int currentStart = meeting[0];
            int currentEnd = meeting[1];

            if(lastMeetingDay < currentStart) {
                result += currentStart - lastMeetingDay - 1;
            }

            lastMeetingDay = Math.max(lastMeetingDay, currentEnd);
        }

        result += days - lastMeetingDay;

        return result;
    }
}
