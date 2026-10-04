class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder bldr = new StringBuilder();

        PriorityQueue<int[]> maxQueue = new PriorityQueue<>((valueA, valueB) -> valueB[0] - valueA[0]);
        if (a > 0) {
            maxQueue.add(new int[] {a, 'a'});
        }

        if (b > 0) {
            maxQueue.add(new int[] {b, 'b'});
        }

        if (c > 0) {
            maxQueue.add(new int[] {c, 'c'});
        }

        while (!maxQueue.isEmpty()) {
            int[] maxEntry = maxQueue.poll();
            int maxEntryCount = maxEntry[0];
            char maxEntryCharacter = (char) maxEntry[1];
            int n = bldr.length();

            if (n >= 2 && bldr.charAt(n-2) ==  bldr.charAt(n-1) &&  bldr.charAt(n-1) == maxEntryCharacter) {
                if (maxQueue.isEmpty()) {
                    return bldr.toString();
                }
                int[] secondMaxEntry = maxQueue.poll();
                int secondMaxEntryCount = secondMaxEntry[0];
                char secondMaxEntryCharacter = (char) secondMaxEntry[1];
                bldr.append(secondMaxEntryCharacter);

                if (secondMaxEntryCount > 1) {
                    maxQueue.add(new int[] {secondMaxEntryCount - 1, secondMaxEntryCharacter});
                }
                maxQueue.add(new int[] {maxEntryCount, maxEntryCharacter});
            } else {
                bldr.append(maxEntryCharacter);
                if (maxEntryCount > 1) {
                    maxQueue.add(new int[] {maxEntryCount - 1, maxEntryCharacter});
                }
            }
        }

        return bldr.toString();
    }
}