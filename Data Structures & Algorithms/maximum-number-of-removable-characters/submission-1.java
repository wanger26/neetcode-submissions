class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {

        int indexS = 0;
        int indexP = 0;
        int left = 0;
        int right = removable.length - 1;

        int result = 0;
        while(left <= right) {
            int pivot = (left+right)/2;

            Set<Integer> skips = new HashSet<>();
            for(int i = 0; i <= pivot; i++) {
                skips.add(removable[i]);
            }

            if(isSubsequence(s, p, skips)) {
                result = pivot + 1;
                left = pivot + 1; 
            } else {
                right = pivot - 1;
            }
        }

        return result;
    }

    private boolean isSubsequence(String s, String p, Set<Integer> skips) {
        int indexP = 0;
        for(int indexS = 0; indexS < s.length() && indexP < p.length(); indexS++) {
            if(!skips.contains(indexS)) {
                if(s.charAt(indexS) == p.charAt(indexP)) {
                    indexP++;
                }
            }
        }

        return indexP == p.length();
    }
}
