class CountSquares {
    private Map<Integer, Map<Integer, Integer>> rowYToXPoints;
    private Map<Integer, Map<Integer, Integer>> colXToYPoints;

    public CountSquares() {
        rowYToXPoints = new HashMap<>();
        colXToYPoints = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        if (!colXToYPoints.containsKey(x)) {
            colXToYPoints.put(x, new HashMap<>());
        }
        colXToYPoints.get(x).put(y, colXToYPoints.get(x).getOrDefault(y, 0) + 1);

        if (!rowYToXPoints.containsKey(y)) {
            rowYToXPoints.put(y, new HashMap<>());
        }
        rowYToXPoints.get(y).put(x, rowYToXPoints.get(y).getOrDefault(x, 0) + 1);
    }

    public int count(int[] point) {
        int result = 0;
        int x = point[0];
        int y = point[1];

        if(!colXToYPoints.containsKey(x) || !rowYToXPoints.containsKey(y)) {
            return result;
        }

        for(Map.Entry<Integer, Integer> yAndFreq : colXToYPoints.get(x).entrySet()) {
            int otherY = yAndFreq.getKey();
            int freq = yAndFreq.getValue();

            if(y == otherY) {
                continue;
            }

            int side = Math.abs(y-otherY);
            int leftX = x - side;
            int rightX = x + side;

            result += freq * rowYToXPoints.get(y).getOrDefault(leftX, 0) * rowYToXPoints.get(otherY).getOrDefault(leftX, 0);
            result += freq * rowYToXPoints.get(y).getOrDefault(rightX, 0) * rowYToXPoints.get(otherY).getOrDefault(rightX, 0);
        }

        return result;
    }
}
