class SummaryRanges {
    private final TreeMap<Integer, Integer> intervals;

    public SummaryRanges() {
        this.intervals = new TreeMap<>();
    }

    // Time: O(logI)
    public void addNum(int value) {
        Map.Entry<Integer, Integer> left = intervals.floorEntry(value);
        if(left != null && value <= left.getValue()) {
            return;
        }

        Map.Entry<Integer, Integer> right = intervals.ceilingEntry(value);
        boolean joinsLeft = left != null && left.getValue() + 1 == value;
        boolean joinsRight = right != null && right.getKey() - 1 == value;

        if(joinsLeft && joinsRight) {
            intervals.put(left.getKey(), right.getValue());
            intervals.remove(right.getKey());
        } else if (joinsLeft) {
            intervals.put(left.getKey(), value);
        } else if (joinsRight) {
            intervals.put(value, right.getValue());
            intervals.remove(right.getKey());
        } else {
            intervals.put(value, value);
        }

    }

    // Time: O(I)
    public int[][] getIntervals() {
        int[][] result = new int[intervals.size()][2];
        int index = 0;
        for(Map.Entry<Integer, Integer> entry : intervals.entrySet()) {
            result[index][0] = entry.getKey();
            result[index][1] = entry.getValue();
            index++;
        }

        return result;
    }
}
