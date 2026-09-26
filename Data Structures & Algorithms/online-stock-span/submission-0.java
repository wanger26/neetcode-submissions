class StockSpanner {

    private List<Integer> prices;
    private List<Integer> daySpans;
    public StockSpanner() {
        this.prices = new ArrayList<>();
        this.daySpans = new ArrayList<>();
    }
    
    public int next(int price) {
        if(prices.isEmpty()) {
            prices.add(price);
            daySpans.add(1);
        } else {
            prices.add(price);
            int index = prices.size()-2;
            while(index >= 0 && prices.get(index) <= price) {
                index -= daySpans.get(index);
            }
            daySpans.add(prices.size() - index - 1);
        }

        return daySpans.getLast();
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */