class BrowserHistory {

    private Stack<String> backStack;
    private Stack<String> forwardStack;

    public BrowserHistory(String homepage) {
        this.backStack = new Stack<>();
        this.forwardStack = new Stack<>();

        this.backStack.push(homepage);
    }
    
    public void visit(String url) {
        backStack.add(url);
        forwardStack.clear();
    }
    
    public String back(int steps) {
        while(backStack.size() > 1 && steps > 0) {
            forwardStack.push(backStack.pop());   
            steps--;
        }

        return backStack.peek();
    }
    
    public String forward(int steps) {
        while(!forwardStack.isEmpty() && steps > 0) {
            backStack.push(forwardStack.pop());
            steps--;
        }

        return backStack.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */