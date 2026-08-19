class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> valueToFrequency = new HashMap<>();

        for (int num : nums) {
            valueToFrequency.put(num, valueToFrequency.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] frequencyBucketToValue = new List[nums.length + 1];
        for (int num : valueToFrequency.keySet()) {
            int frequency = valueToFrequency.get(num);
            if(frequencyBucketToValue[frequency] == null) {
                frequencyBucketToValue[frequency] = new ArrayList<>();
            }
            frequencyBucketToValue[frequency].add(num);
        }

        int index = 0;
        int[] result = new int[k];
        for (int frequency = frequencyBucketToValue.length - 1; frequency >= 0; frequency--) {
            if (frequencyBucketToValue[frequency] != null) {
                for (int number : frequencyBucketToValue[frequency]) {
                    if (index == k) {
                        break;
                    }
                    result[index] = number;
                    index++;
                }
            }
        }

        return result;
    }
}
