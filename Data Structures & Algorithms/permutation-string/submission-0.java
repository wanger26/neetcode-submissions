class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> s1CharIntCount = new HashMap<>();
        Map<Character, Integer> windowCharCount = new HashMap<>();

        for(char character : s1.toCharArray()) {
            s1CharIntCount.put(character, s1CharIntCount.getOrDefault(character, 0) + 1);
        }


        int left = 0;
        int right = 0;

        while(right < s2.length()) {
            char character = s2.charAt(right);

            // If s1 does not contain character --> character cannot be in solution. Skip ahead
            if(!s1CharIntCount.containsKey(character)) {
                right++;
                left = right;
                windowCharCount.clear();
                continue;
            }

            windowCharCount.put(character, windowCharCount.getOrDefault(character, 0) + 1);

            // If current count is too high, won't work. Remove until you are back
            while(windowCharCount.get(character) > s1CharIntCount.get(character)) {
                char leftCharacter = s2.charAt(left);
                windowCharCount.put(leftCharacter, windowCharCount.get(leftCharacter) - 1);
                left++;
            }

            if(s1CharIntCount.equals(windowCharCount)) {
                System.out.println(windowCharCount);
                return true;
            }
            right++;
        }

        return false;
    }
}
