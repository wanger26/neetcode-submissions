class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int child = 0;
        
        for(int cookieIndex = 0; cookieIndex < s.length && child < g.length; cookieIndex++) {
            if(s[cookieIndex] >= g[child]) {
                child++;
            }
        }
        return child;
    }
}