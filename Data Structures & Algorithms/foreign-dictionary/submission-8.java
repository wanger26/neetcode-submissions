class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String word : words) {
            for (char character : word.toCharArray()) {
                graph.putIfAbsent(character, new HashSet<>());
                indegree.putIfAbsent(character, 0);
            }
        }

        for (int i = 1; i < words.length; i++) {
            String word1 = words[i - 1];
            String word2 = words[i];

            int index = 0;
            int minLength = Math.min(word1.length(), word2.length());
            while (index < minLength && word1.charAt(index) == word2.charAt(index)) {
                index++;
            }

            if (index == minLength && word1.length() > word2.length()) {
                return "";
            }

            if (index < minLength) {
                char char1 = word1.charAt(index);
                char char2 = word2.charAt(index);

                if (graph.get(char1).add(char2)) {
                    indegree.put(char2, indegree.get(char2) + 1);
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : indegree.entrySet()) {
            char character = entry.getKey();
            int degree = entry.getValue();
            if (degree == 0) {
                queue.add(character);
            }
        }

        String result = "";
        while (!queue.isEmpty()) {
            char character = queue.poll();
            result += character;

            for (char neighbor : graph.get(character)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);

                if (indegree.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }

        for (int degree : indegree.values()) {
            // If there is a node left with a degree more than 1 there is a cycle
            if (degree > 0) {
                return "";
            }
        }

        return result;
    }
}
