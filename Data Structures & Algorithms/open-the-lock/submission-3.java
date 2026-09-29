class Solution {
    public int openLock(String[] deadends, String target) {
        // Boolean array provides O(1) lookups with zero hashing overhead
        boolean[] seen = new boolean[10000];
        
        for (String deadend : deadends) {
            seen[Integer.parseInt(deadend)] = true;
        }

        int targetNum = Integer.parseInt(target);
        
        // ArrayDeque is faster than LinkedList (no per-node object allocation)
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(targetNum);
        seen[targetNum] = true;
        
        int turns = 0;
        
        // Powers of 10 used to isolate and modify specific digits mathematically
        int[] pow10 = {1, 10, 100, 1000};
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                
                // Base case: we successfully reached 0000
                if (curr == 0) {
                    return turns;
                }
                
                // Iterate through each of the 4 wheels
                for (int p : pow10) {
                    // Extract the specific digit at the current wheel (0-9)
                    int digit = (curr / p) % 10;
                    
                    // 1 represents turning forward, 9 represents turning backward
                    for (int move : new int[]{1, 9}) {
                        int newDigit = (digit + move) % 10;
                        
                        // Mathematically reconstruct the new combination
                        int nextNum = curr - (digit * p) + (newDigit * p);
                        
                        // If we haven't visited this state and it's not a deadend
                        if (!seen[nextNum]) {
                            seen[nextNum] = true;
                            queue.add(nextNum);
                        }
                    }
                }
            }
            turns++;
        }
        
        return -1;
    }
}