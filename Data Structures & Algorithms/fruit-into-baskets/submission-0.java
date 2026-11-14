class Solution {
    public int totalFruit(int[] fruits) {
        // fruits = [1,2,3,2,2]

        Map<Integer, Integer> fruitsToFreq = new HashMap<>();
        int result = 0;
        int left = 0;
        for(int right = 0; right < fruits.length; right++) {
            int fruit = fruits[right];

            fruitsToFreq.put(fruit, fruitsToFreq.getOrDefault(fruit, 0) + 1);
            while(fruitsToFreq.size() == 3) {
                int leftFruit = fruits[left];
                fruitsToFreq.put(leftFruit, fruitsToFreq.get(leftFruit) - 1);

                if(fruitsToFreq.get(leftFruit) == 0) {
                    fruitsToFreq.remove(leftFruit);
                }
                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}