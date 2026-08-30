class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (beginWord.equals(endWord)) {
            return 0;
        }

        int result = 0;
        Set<String> seen = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        while(!queue.isEmpty()) {
            result++;
            int initalSize = queue.size();
            for(int i=0; i < initalSize; i++) {
                String word = queue.poll();
                
                if(seen.contains(word)) {
                    continue;
                }
                seen.add(word);
                if(word.equals(endWord)) {
                    return result;
                }

                for(String nextWord : wordList) {
                    if(seen.contains(nextWord) || nextWord.equals(word)) {
                        continue;
                    }
                    int differences = 0;
                    for(int index=0; index < word.length() && differences <= 1; index++) {
                        if(word.charAt(index) != nextWord.charAt(index)) {
                            differences++;
                        }
                    }

                    if(differences == 1) {
                        queue.add(nextWord);
                    }
                }
            }
        }

        return 0;
    }
}
