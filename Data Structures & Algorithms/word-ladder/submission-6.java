class Solution {
    // Time: O(n*L^2) where L is the length of the strings
    // Space: O(n*L)
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (beginWord.equals(endWord)) {
            return 0;
        }

        int result = 0;
        Set<String> seen = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        seen.add(beginWord);
        while (!queue.isEmpty()) { // O(n)
            result++;
            int initalSize = queue.size();
            for (int i = 0; i < initalSize; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return result;
                }

                for (int j = 0; j < word.length(); j++) {
                    for (char character = 'a'; character <= 'z'; character++) {
                        String newWord = word.substring(0, j) + character + word.substring(j + 1);
                        if (!wordSet.contains(newWord) || seen.contains(newWord) || newWord.equals(word)) {
                            continue;
                        }
                        queue.add(newWord);
                        seen.add(newWord);
                    }
                }
            }
        }

        return 0;
    }
}
