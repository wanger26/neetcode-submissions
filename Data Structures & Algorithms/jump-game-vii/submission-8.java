class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();

        if(s.charAt(n-1) == '1') {
            return false;
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.add(0);
        visited[0] = true;

        while(!queue.isEmpty()) {
            int index = queue.poll();

            for(int jump = minJump; jump <= maxJump && jump + index < n; jump++) {
                int nextIndex = index + jump;

                if(visited[nextIndex]) {
                    continue;
                }

                visited[nextIndex] = true;
                if(s.charAt(nextIndex) == '0') {
                    queue.add(nextIndex);                    
                }
            }
        }

        return visited[n-1];
    }
}