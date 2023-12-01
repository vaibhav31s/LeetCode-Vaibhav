class MedianFinder {
    PriorityQueue<Integer> pq1;
    PriorityQueue<Integer> pq2;
    public MedianFinder() {
        pq1 = new PriorityQueue<>(Collections.reverseOrder());
        pq2 = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        pq1.add(num);
        pq2.add(pq1.poll());
        if(pq1.size() < pq2.size() ) {
            pq1.add(pq2.poll());
        }
    }
    // returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
    public double findMedian() {
        // if(pq1.get(i))
        int size1 = pq1.size();
        int size2 = pq2.size();
        
        if ((size1 + size2 ) % 2 == 0){
            System.out.println(pq1.peek() + "  " + pq2.peek());
            return (pq1.peek() + pq2.peek()) / 2.0;
        }else
            {
            return pq1.peek();}
    }

}


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */