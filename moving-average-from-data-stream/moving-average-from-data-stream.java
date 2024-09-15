class MovingAverage {
    Deque<Integer> dq;
    int size;
    Double curSum = 0.0;
    public MovingAverage(int size) {
        dq = new LinkedList<>();
        this.size  = size;
    }
    
    public double next(int val) {
        
        dq.add(val);
        curSum += val;
        if (dq.size() > size) {
            Double valFirst = (double) dq.pollFirst();    
            curSum -= valFirst;
        }
        return  curSum / dq.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */