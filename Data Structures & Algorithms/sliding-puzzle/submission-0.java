class Solution {
    public int slidingPuzzle(int[][] board) {
        
        int[][] adjacent = new int[][]{
            {1,3},
            {0,2,4},
            {1,5},
            {0,4},
            {1,3,5},
            {2,4}
        };

        StringBuilder bldr = new StringBuilder();
        for(int i = 0; i < 3; i++) {
            bldr.append(board[0][i]);
        }

        for(int i = 0; i < 3; i++) {
            bldr.append(board[1][i]);
        }

        String initalKey = bldr.toString();

        Queue<String> queue = new LinkedList<>();
        queue.add(initalKey);

        Set<String> visited = new HashSet<>();
        visited.add(initalKey);

        String desired = "123450";
        int result = 0;
        while(!queue.isEmpty()) {
            int initalSize = queue.size();

            for(int i = 0; i < initalSize; i++) {
                String boardConfig = queue.poll();

                if(boardConfig.equals(desired)) {
                    return result;
                }

                int zeroIndex = -1;
                for(int j = 0; j < boardConfig.length() && zeroIndex == -1; j++) {
                    if(boardConfig.charAt(j) == '0') {
                        zeroIndex = j;
                    }
                }

                for(int neighbor : adjacent[zeroIndex]) {
                    char[] nextConfig = boardConfig.toCharArray();
                    char temp = nextConfig[zeroIndex];
                    nextConfig[zeroIndex] = nextConfig[neighbor];
                    nextConfig[neighbor] = temp;

                    String newBoardConfigString = new String(nextConfig);
                    if(visited.add(newBoardConfigString)) {
                        queue.add(newBoardConfigString);
                    }
                }
            }

            result++;
        }

        return -1;


    }
}
