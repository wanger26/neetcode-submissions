class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length;

        Node head = new Node();
        addWord(head, words[n-1]);

        int result = 0;
        for(int i = n-2; i >= 0; i--) {
            String word = words[i];
            Node currentNode = head;
            boolean valid = true;
            for(int j = 0; j < word.length() && valid; j++) {
                String key = word.charAt(j) + "," + word.charAt(word.length() - 1 - j);
                if(!currentNode.children.containsKey(key)) {
                    valid = false;
                } else {
                    currentNode = currentNode.children.get(key);
                }
            }

            if(valid) {
                result += currentNode.count;
            }

            addWord(head, word);
        }

        return result;
    }

    private Node addWord(Node parentNode, String word) {
        Node currentNode = parentNode;
        for(int i = 0; i < word.length(); i++) {
            String key = word.charAt(i) + "," + word.charAt(word.length() - 1 - i);

            if(!currentNode.children.containsKey(key)) {
                currentNode.children.put(key, new Node());
            }
            currentNode = currentNode.children.get(key);
            currentNode.count++;
        }

        return parentNode;
    }

    public class Node {
        public Map<String, Node> children = new HashMap<>();
        public int count;
    }
}