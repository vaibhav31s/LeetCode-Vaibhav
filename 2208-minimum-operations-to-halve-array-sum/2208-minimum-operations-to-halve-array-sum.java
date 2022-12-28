class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>((a,b)-> Double.compare(b,a));
        double sum = 0;
        double cur = 0;
        for(int x : nums){
            sum += x;
            cur += x;
        }
        for(int x : nums) pq.add((double)x);
        sum/=2;
        int count =0;
        while(sum  < cur){
            double last = pq.poll();
            cur -= last;
            last = last / 2;
            cur += last;
            pq.add(last);
            count++;
            // System.out.println(sum + " "+ cur);
        }
        
        return count;
    }
}