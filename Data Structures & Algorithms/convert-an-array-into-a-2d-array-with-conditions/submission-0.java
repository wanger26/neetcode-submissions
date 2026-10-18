class Solution {
    public int[][] findMatrix(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int maxFrequency = 0;

        for(int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            maxFrequency =Math.max(maxFrequency, freqMap.get(num));
        }

        List<Integer>[] result = new List[maxFrequency];
        for(int i = 0; i < result.length; i++) {
            result[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int num = entry.getKey();
            int frequency = entry.getValue();
            for(int i = 0; i < frequency; i++) {
                result[i].add(num);
            }
        }

        int[][] resultArray = new int[result.length][];
        for(int i=0; i < result.length; i++) {
            List<Integer> row = result[i];
            resultArray[i] = new int[row.size()];
            for(int j = 0; j < row.size(); j++) {
                resultArray[i][j] = row.get(j);
            }
        }

        return resultArray;        
    }
}
