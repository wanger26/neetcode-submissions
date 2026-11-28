class Solution {
    public String foreignDictionary(String[] words) {
        List<Integer>[] graph = new List[26];
        for (int i = 0; i < 26; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] indegree = new int[26];
        int[] frequency = new int[26];
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                frequency[word.charAt(i) - 'a']++;
            }
        }

        boolean anyQualify = true;
        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i];
            String second = words[i + 1];
            int commonLength = Math.min(first.length(), second.length());

            int index = 0;
            while (index < commonLength && first.charAt(index) == second.charAt(index)) {
                index++;
            }

            if (index == commonLength) {
                if (first.length() > second.length()) {
                    return "";
                }
                continue;
            }

            int from = first.charAt(index) - 'a';
            int to = second.charAt(index) - 'a';
            graph[from].add(to);
            indegree[to]++;
        }

        int numberOfChars = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (frequency[i] == 0) {
                continue;
            }

            numberOfChars++;
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.append((char) (node + 'a'));
            for (int neighbor : graph[node]) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return result.length() == numberOfChars ? result.toString() : "";
    }
}
