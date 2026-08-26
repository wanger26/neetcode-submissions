class Solution {

    // Time: O(n^2)
    // Space: O(n^2)

    public int lengthOfLIS(int[] nums) {
        Map<Key, Integer> memo = new HashMap<>();
        return recurse(nums, 0, Integer.MIN_VALUE, memo);
    }

    private int recurse(int[] nums, int index, int biggestNumber, Map<Key, Integer> memo) {
        Key key = new Key(index, biggestNumber);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        else if(index == nums.length) {
            return 0;
        }

        int result = 0;
        
        // If number at index is bigger than current biggestNumber. Lets try an include
        if(biggestNumber < nums[index]) {
            result = recurse(nums, index+1, nums[index], memo) + 1;
        }

        // Now lets try not taking the current
        result = Math.max(result, recurse(nums, index+1, biggestNumber, memo));

        memo.put(key, result);
        return result;
    }

    private record Key(int index, int biggestNumber){}
}
