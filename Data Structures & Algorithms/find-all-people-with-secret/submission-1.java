class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

        PriorityQueue<int[]> minQueue = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        for(int[] meeting : meetings) {
            minQueue.add(meeting);
        }

        List<int[]>[] graph = new List[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new int[]{firstPerson, 0});
        while(!minQueue.isEmpty()) {
            int[] meeting = minQueue.poll();
            int personA = meeting[0];
            int personB = meeting[1];
            int time = meeting[2];

            graph[personA].add(new int[]{personB, time});
            graph[personB].add(new int[]{personA, time});
        }

        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new LinkedHashSet<>();
        queue.add(new int[]{0, 0});
        visited.add(0);

        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int person = node[0];
            int time = node[1];

            for(int[] neighbor : graph[person]) {
                int neighborPerson = neighbor[0];
                int neighborTime = neighbor[1];
                if(time <= neighborTime && !visited.contains(neighborPerson)) {
                    visited.add(neighborPerson);
                    queue.add(neighbor);
                }
            }
        }

        return new ArrayList<>(visited);
    }
}
