class Solution {
    public int lastStoneWeight(int[] stones) {
        int maxStone = 0;
        for(int stone : stones) {
            maxStone = Math.max(maxStone, stone);
        }

        int[] buckets = new int[maxStone+1];
        for(int stone : stones) {
            buckets[stone]++;
        }

        int firstStone = maxStone;
        int secondStone = maxStone;

        while(firstStone > 0) {
            if(buckets[firstStone] % 2 == 0) {
                firstStone--;
                continue;
            }

            int j = Math.min(firstStone-1, secondStone);
            while(j > 0 && buckets[j] == 0) {
                j--;
            }

            if(j == 0) {
                return firstStone;
            }

            secondStone = j;
            buckets[firstStone]--;
            buckets[secondStone]--;
            buckets[firstStone-secondStone]++;
            firstStone = Math.max(firstStone-secondStone, secondStone);
        }

        return firstStone;
    }
}
