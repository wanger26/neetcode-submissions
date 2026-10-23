class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

        // Time: O(n + m log m)
        // Space: O(n + m)
        // m = meetings.length
        List<int[]>[] graph = new List[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] meeting : meetings) {
            int personA = meeting[0];
            int personB = meeting[1];
            int time = meeting[2];

            graph[personA].add(new int[]{personB, time});
            graph[personB].add(new int[]{personA, time});
        }

        int[] earliestTime = new int[n];
        Arrays.fill(earliestTime, Integer.MAX_VALUE);

        PriorityQueue<int[]> minQueue = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        earliestTime[0] = 0;
        earliestTime[firstPerson] = 0;

        minQueue.add(new int[]{0, 0});
        minQueue.add(new int[]{firstPerson, 0});

        while (!minQueue.isEmpty()) {
            int[] node = minQueue.poll();

            int person = node[0];
            int time = node[1];

            // Ignore an outdated entry.
            if (time > earliestTime[person]) {
                continue;
            }

            for (int[] neighbor : graph[person]) {
                int neighborPerson = neighbor[0];
                int meetingTime = neighbor[1];

                if (meetingTime >= time &&
                    meetingTime < earliestTime[neighborPerson]) {

                    earliestTime[neighborPerson] = meetingTime;

                    minQueue.add(new int[]{neighborPerson, meetingTime});
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int person = 0; person < n; person++) {
            if (earliestTime[person] != Integer.MAX_VALUE) {
                result.add(person);
            }
        }

        return result;
    }
}