class Solution {
    public int mostBooked(int n, int[][] meetings) {
        
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        // Min-heap for free rooms (sorted by room index)
        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            freeRooms.add(i);
        }

        // Min-heap for busy rooms: [endTime, roomIndex]
        PriorityQueue<long[]> busyRooms = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Long.compare(a[0], b[0]);
            }
            return Long.compare(a[1], b[1]);
        });

        int[] meetingRoomUsage = new int[n];

        for(int[] meeting : meetings) {
            int meetingDuration = meeting[1] - meeting[0];
            
            int meetingRoom;
            long endTime;

            while(!busyRooms.isEmpty() && busyRooms.peek()[0] <= meeting[0]) {
                freeRooms.add((int)busyRooms.poll()[1]);
            }

            if(!freeRooms.isEmpty()) {
                meetingRoom = freeRooms.poll();
                endTime = meeting[1];
            } else {
                long[] room = busyRooms.poll();
                long roomEndTime = room[0];
                meetingRoom = (int)room[1];
                endTime = roomEndTime + (long)meetingDuration;
            }
            
            busyRooms.add(new long[]{endTime, meetingRoom});
            meetingRoomUsage[meetingRoom]++;
        }


        int result = 0;
        int maxMeetings = 0;
        for(int i=0; i < n; i++) {
            if(maxMeetings < meetingRoomUsage[i]){
                result = i;
                maxMeetings = meetingRoomUsage[i];
            }
        }

        return result;
    }
}