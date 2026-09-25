class Solution {
    public int numRescueBoats(int[] people, int limit) {

        // Time: O(n + m) where m is the size of the heaviest person
        // Space: O(n + m)
        int max = 0;
        for (int person : people) {
            max = Math.max(max, person);
        }

        int[] count = new int[max + 1];
        for (int person : people) {
            count[person]++;
        }

        int peopleIndex = 0;
        int countIndex = 1;
        while (peopleIndex < people.length) {
            while (count[countIndex] == 0) {
                countIndex++;
            }

            people[peopleIndex] = countIndex;
            count[countIndex]--;

            peopleIndex++;
        }

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