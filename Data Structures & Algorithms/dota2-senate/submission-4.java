class Solution {
    public String predictPartyVictory(String senate) {

        int n = senate.length();
        Queue<Integer> radiants = new ArrayDeque<>();
        Queue<Integer> dires = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            char character = senate.charAt(i);
            if(character == 'R') {
                radiants.add(i);
            } else {
                dires.add(i);
            }
        }

        while(!radiants.isEmpty() && !dires.isEmpty()) {
            int radiantIndex = radiants.poll();
            int direIndex = dires.poll();

            // If radiant comes before dire. Radiant surives
            if(radiantIndex < direIndex) {
                radiants.add(radiantIndex + n);
            } else {
                dires.add(direIndex + n);
            }
        }

        if(radiants.isEmpty()) {
            return "Dire";
        } else {
            return "Radiant";
        }
    }
}