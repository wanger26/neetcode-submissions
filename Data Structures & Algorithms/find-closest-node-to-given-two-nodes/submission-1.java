class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {

        // Time: O(n)
        // Space: O(n)
        int n = edges.length;
        boolean[] seen1 = new boolean[n];
        boolean[] seen2 = new boolean[n];

        while (!seen1[node1] && !seen2[node2]) {
            seen1[node1] = true;
            seen2[node2] = true;

            if (seen2[node1] && seen1[node2]) {
                return node1 < node2 ? node1 : node2;
            } else if (seen2[node1]) {
                return node1;
            } else if (seen1[node2]) {
                return node2;
            }

            if (edges[node1] != -1) {
                node1 = edges[node1];
            }

            if (edges[node2] != -1) {
                node2 = edges[node2];
            }
        }

        while (!seen1[node1]) {
            seen1[node1] = true;
            if (seen2[node1]) {
                return node1;
            }

            if (edges[node1] != -1) {
                node1 = edges[node1];
            }
        }

        while (!seen2[node2]) {
            seen2[node2] = true;
            if (seen1[node2]) {
                return node2;
            }

            if (edges[node2] != -1) {
                node2 = edges[node2];
            }
        }


        return -1;
    }
}
