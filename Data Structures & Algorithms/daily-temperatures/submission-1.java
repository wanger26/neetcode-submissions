class Solution {
    // Time: O(n)
    // Space: O(n)
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> expandableDays = new Stack<>();
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            int currentTemp = temperatures[i];

            // If our current temp is > the expandable days we have seen, they are no longer
            // expandable. Add result
            while (!expandableDays.isEmpty() && currentTemp > temperatures[expandableDays.peek()]) {
                int index = expandableDays.pop();
                int numDays = i - index;
                result[index] = numDays;
            }

            expandableDays.add(i);
        }

        // Clean up any records left
        while (!expandableDays.isEmpty()) {
            int index = expandableDays.pop();
            result[index] = 0;
        }
        return result;
    }
}
