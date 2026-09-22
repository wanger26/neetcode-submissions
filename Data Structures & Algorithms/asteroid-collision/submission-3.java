class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        // Time: O(n)
        // Space: O(n)
        Deque<Integer> asteroidsMovingRight = new ArrayDeque<>();
        List<Integer> asteroidsMovedLeftSuccesfully = new ArrayList<>();

        for (int i=0; i < asteroids.length; i++) {
            if (asteroids[i] < 0) {
                while (!asteroidsMovingRight.isEmpty() && asteroidsMovingRight.peekLast() < Math.abs(asteroids[i])) {
                    asteroidsMovingRight.removeLast();
                }

                if(!asteroidsMovingRight.isEmpty() && asteroidsMovingRight.peekLast() == Math.abs(asteroids[i])) {
                    asteroidsMovingRight.removeLast();
                    continue;
                }

                if(asteroidsMovingRight.isEmpty()) {
                    asteroidsMovedLeftSuccesfully.add(asteroids[i]);
                }

            } else {
                asteroidsMovingRight.addLast(asteroids[i]);
            }
        }

        int[] result = new int[asteroidsMovedLeftSuccesfully.size() + asteroidsMovingRight.size()];
        for (int i = 0; i < result.length; i++) {
            if(i < asteroidsMovedLeftSuccesfully.size()) {
                result[i] = asteroidsMovedLeftSuccesfully.get(i);
            } else {
                result[i] = asteroidsMovingRight.removeFirst();
            }
        }

        return result;
    }
}