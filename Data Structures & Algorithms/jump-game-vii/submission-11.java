class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        // Time: O(n)
        // Space: O(n)
        int n = s.length();

        if (s.charAt(n - 1) == '1') {
            return false;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        int farthest = 0;
        while (!queue.isEmpty()) {
            int index = queue.poll();

            int start = Math.max(index + minJump, farthest + 1);
            int end = Math.min(index + maxJump, n - 1);
            for (int i = start; i <= end; i++) {
                if (s.charAt(i) == '0') {
                    if (i == n - 1) {
                        return true;
                    }
                    queue.add(i);
                }
                farthest = Math.max(farthest, i);
            }
        }

        return false;
    }
}