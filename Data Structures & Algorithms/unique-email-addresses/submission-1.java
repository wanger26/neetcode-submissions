class Solution {
    public int numUniqueEmails(String[] emails) {
        // Time: O(n)
        // Space: O(m) where m is the number of unique emails
        Set<String> uniqueEmails = new HashSet<>();
        for(String email : emails) {
            String[] parts = email.split("@");
            StringBuilder normalizedEmail = new StringBuilder();
            for(int i = 0; i < parts[0].length(); i++) {
                char character = parts[0].charAt(i);
                if(character == '.') {
                    continue;
                } else if (character == '+') {
                    break;
                }
                normalizedEmail.append(character);
            }
            normalizedEmail.append("@");
            normalizedEmail.append(parts[1]);
            uniqueEmails.add(normalizedEmail.toString());
        }

        return uniqueEmails.size();
    }
}