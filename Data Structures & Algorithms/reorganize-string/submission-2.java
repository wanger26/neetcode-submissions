class Solution {
    public String reorganizeString(String s) {
        int maxFrequency = 0;
        int[] characterCount = new int[26];
        for(char character : s.toCharArray()) {
            characterCount[character - 'a']++;
            maxFrequency = Math.max(maxFrequency, characterCount[character - 'a']);
        }
        
        if(maxFrequency > (s.length()+1)/2) {
            return "";
        }

        PriorityQueue<Integer> maxFrequencyQueue = new PriorityQueue<>((a,b) -> characterCount[b] - characterCount[a]); 
        for(int i=0; i < 26; i++) {
            if(characterCount[i] > 0) {
                maxFrequencyQueue.add(i);
            }
        }

        int prevCharIndex = -1;
        StringBuilder bldr = new StringBuilder();
        while(!maxFrequencyQueue.isEmpty()) {
            char character = (char)(maxFrequencyQueue.poll() + 'a');
            characterCount[character - 'a']--;
            bldr.append(character);

            if(prevCharIndex != -1 && characterCount[prevCharIndex] > 0) {
                maxFrequencyQueue.add(prevCharIndex);
            }

            prevCharIndex = character - 'a';
        }


        return bldr.toString();
    }
}