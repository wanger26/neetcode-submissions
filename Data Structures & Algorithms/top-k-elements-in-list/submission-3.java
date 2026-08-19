class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> valueToFrequency = new HashMap<>();

        for (int num : nums) {
            valueToFrequency.put(num, valueToFrequency.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];
        for (int num : valueToFrequency.keySet()) {
            int frequency = valueToFrequency.get(num);
            if(bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(num);
        }

        int index = 0;
        int[] result = new int[k];
        for (int frequency = bucket.length - 1; frequency >= 0; frequency--) {
            if (bucket[frequency] != null) {
                for (int number : bucket[frequency]) {
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
