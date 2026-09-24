class Solution {
    public int numSquares(int n) {

        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        int result = 0;
        while(!queue.isEmpty()) {
            int initalSize = queue.size();
            result++;
            for(int k = 0; k < initalSize; k++) {
                int current = queue.poll();

                for(int base = 1; base*base <= current; base++) {
                    int perfectSquare = base*base;
                    int nextNum = current - perfectSquare;

                    if(nextNum == 0) {
                        return result;
                    }

                    if(!visited[nextNum]) {
                        queue.add(nextNum);
                        visited[nextNum] = true;
                    }
                }
            }
        }

        return result;
    }
}