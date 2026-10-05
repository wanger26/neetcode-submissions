class FreqStack {
    // Maps the value to its current total frequency
    private Map<Integer, Integer> freq;
    
    // Maps a frequency count to a Stack of elements that have reached that frequency
    private Map<Integer, Stack<Integer>> group;
    
    // Tracks the current highest frequency in the stack
    private int maxFreq;

    public FreqStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        // Increment the frequency for this value
        int newFrequency = freq.getOrDefault(val, 0) + 1;
        freq.put(val, newFrequency);
        
        // Update the maximum frequency if necessary
        maxFreq = Math.max(maxFreq, newFrequency);
        
        // Add the value to the stack for this specific frequency
        if(!group.containsKey(newFrequency)) {
            group.put(newFrequency, new Stack<>());
        }
        group.get(newFrequency).push(val);
    }

    public int pop() {
        // Pop the most recent element from the stack of the highest frequency
        int val = group.get(maxFreq).pop();
        
        // Decrement its overall frequency in the freq map
        freq.put(val, freq.get(val) - 1);
        
        // If there are no more elements at this max frequency, lower the maxFreq boundary
        if (group.get(maxFreq).isEmpty()) {
            maxFreq--;
        }
        
        return val;
    }
}