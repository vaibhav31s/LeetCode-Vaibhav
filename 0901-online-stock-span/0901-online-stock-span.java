class StockSpanner {
    Stack<Pair<Integer,  Integer> > span;
    
    public StockSpanner() {
        span = new Stack<>();    
    }
    
    public int next(int price) {
            int sum  = 1;
        if(span.isEmpty()){
            span.push(new Pair(price, 1));
        }else{
            while(!span.isEmpty() && span.peek().getKey() <= price){
                sum += span.pop().getValue();
            }
            span.push(new Pair(price,sum));
        }
        
        return sum;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */