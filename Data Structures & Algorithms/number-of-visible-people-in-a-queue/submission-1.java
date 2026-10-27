class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] result = new int[n];
        Stack<Integer> people = new Stack<>();

        for (int i = 0; i < n; i++) {
            int height = heights[i];
            while (!people.isEmpty() && heights[people.peek()] < height) {
                result[people.pop()]++;
            }

            if (!people.isEmpty()) {
                result[people.peek()]++;
            }

            people.push(i);
        }

        return result;
    }
}