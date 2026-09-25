class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;

        int result = 0;
        while (left <= right) {
            // If the lightest person and heaviest person fit, they share the boat
            if (people[left] + people[right] <= limit) {
                left++;
            }

            // The heaviest person always gets on a boat, either shared or alone
            right--;
            result++;
        }

        return result;
    }
}