class Solution {

    // Time: O(n^2*L) where L is the length of the strings
    // Space: O(n)
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (beginWord.equals(endWord)) {
            return 0;
        }

        int result = 0;
        Set<String> seen = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        seen.add(beginWord);
        while(!queue.isEmpty()) { // O(n)
            result++;
            int initalSize = queue.size();
            for(int i=0; i < initalSize; i++) {
                String word = queue.poll();
                if(word.equals(endWord)) {
                    return result;
                }

                for(String nextWord : wordList) { // O(n)
                    if(seen.contains(nextWord) || nextWord.equals(word)) {
                        continue;
                    }
                    int differences = 0;
                    for(int index=0; index < word.length() && differences <= 1; index++) { // O(L)
                        if(word.charAt(index) != nextWord.charAt(index)) {
                            differences++;
                        }
                    }

                    if(differences == 1) {
                        queue.add(nextWord);
                        seen.add(nextWord);
                    }
                }
            }
        }

        return 0;
    }
}
