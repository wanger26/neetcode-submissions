// Space: O(n)
class CountSquares {

    Map<List<Integer>, Integer> pointsCount;

    public CountSquares() {
        this.pointsCount = new HashMap<>();
    }
    
    // Time: O(1)
    public void add(int[] point) {
        List<Integer> key = Arrays.asList(point[0], point[1]);
        pointsCount.put(key, pointsCount.getOrDefault(key, 0) + 1);
    }
    
    // Time: O(n)
    public int count(int[] point) {
        int result = 0;
        int pointX = point[0];
        int pointY = point[1];

        for(List<Integer> p : pointsCount.keySet()) {
            int x = p.get(0);
            int y = p.get(1);
            
            if (Math.abs(pointX - x) != Math.abs(pointY - y) || pointX == x || pointY == y) {
                continue;
            }

            result += pointsCount.get(Arrays.asList(x, y)) * pointsCount.getOrDefault(Arrays.asList(x, pointY), 0) * pointsCount.getOrDefault(Arrays.asList(pointX, y), 0);
        }

        return result;
    }
}
