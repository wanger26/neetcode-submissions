class Solution {
    public int largestRectangleArea(int[] heights) {

        int result = 0;

        // This stack stores the current values under consideration
        Stack<IndexHeightPair> stack = new Stack<>();

        for(int i=0; i < heights.length; i++) {
            int currentHeight = heights[i];
            int index = i;

            if(!stack.isEmpty() && currentHeight < stack.peek().height()) {
                // The current height is smaller than the previous bar(s), we can no longer extend the previous bar(s)
                // While the previous bars are larger then the current height we need to calc their results and pop since they cant be extended 
                while(!stack.isEmpty() && currentHeight < stack.peek().height()) {
                    IndexHeightPair pair = stack.pop();
                    index = pair.index();
                    int height = pair.height();

                    // Calc the area they could have formed
                    int area = height * (i - index);
                    result = Math.max(result, area);
                }
            }

            stack.push(new IndexHeightPair(index, currentHeight));
        }

        while(!stack.isEmpty()) {
            IndexHeightPair pair = stack.pop();
            int index = pair.index();
            int height = pair.height();
            // Calc the area they could have formed
            int area = height * (heights.length - index);
            result = Math.max(result, area);
        }

        return result;
        
    }

    private record IndexHeightPair(int index, int height){}
}
