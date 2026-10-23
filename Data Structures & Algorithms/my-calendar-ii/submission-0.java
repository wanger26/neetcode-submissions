class MyCalendarTwo {

    List<int[]> meetings;
    List<int[]> doubleMeetings;
    public MyCalendarTwo() {
        this.meetings = new ArrayList<>();
        this.doubleMeetings = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        for(int[] meeting : doubleMeetings) {
            int meetingStart = meeting[0];
            int meetingEnd = meeting[1];
            if(endTime > meetingStart && startTime < meetingEnd) {
                return false;
            }
        }

        for(int[] meeting : meetings) {
            int meetingStart = meeting[0];
            int meetingEnd = meeting[1];
            if(endTime > meetingStart && startTime < meetingEnd) {
                doubleMeetings.add(new int[]{Math.max(meetingStart, startTime), Math.min(meetingEnd, endTime)});
            }
        }
        meetings.add(new int[]{startTime, endTime});

        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */