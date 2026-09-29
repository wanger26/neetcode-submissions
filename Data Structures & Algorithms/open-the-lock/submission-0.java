class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> seen = new HashSet<>();
        for (String deadend : deadends) {
            seen.add(deadend);
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(target);
        seen.add(target);

        int turns = 0;
        while (!queue.isEmpty()) {
            int initalSize = queue.size();
            for (int i = 0; i < initalSize; i++) {
                String combo = queue.poll();
                if (combo.equals("0000")) {
                    return turns;
                }

                for (int j = 0; j < 4; j++) {
                    char[] array = combo.toCharArray();
                    array[j] = (char)((array[j] - '0' + 1) % 10 + '0');
                    String combo1 = new String(array);
                    if (!seen.contains(combo1)) {
                        queue.add(combo1);
                        seen.add(combo1);
                    }

                    array = combo.toCharArray();
                    array[j] = (char)((array[j] - '0' - 1) % 10 + '0');
                    String combo2 = new String(array);
                    if (!seen.contains(combo2)) {
                        queue.add(combo2);
                        seen.add(combo2);
                    }
                }
            }
            turns++;
        }

        return -1;
    }
}