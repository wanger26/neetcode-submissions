class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> frequencyCount = new HashMap<>();

        int threshold = nums.length/3;
        for(int num : nums) {
            frequencyCount.put(num, frequencyCount.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : frequencyCount.entrySet()) {
            int num = entry.getKey();
            int frequency = entry.getValue();

            if(frequency > threshold) {
                result.add(num);
            }
        }

        return result;

    }
}